package br.com.coleta.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ClienteDAO;
import br.com.coleta.dao.ItensPedidoDAO;
import br.com.coleta.dao.VendaDAO;
import br.com.coleta.domain.Cliente;
import br.com.coleta.domain.ItemVenda;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;
import br.com.coleta.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private Venda venda;
	private ItensPedido itenspedido;
	private Produto produto;

	private List<Produto> produtos;
	private List<ItensPedido> itenspedidos;
	private List<ItemVenda> itensVenda;
	private List<Cliente> clientes;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItensPedido getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(ItensPedido itenspedido) {
		this.itenspedido = itenspedido;
	}

	public List<ItensPedido> getItenspedidos() {
		return itenspedidos;
	}

	public void setItenspedidos(List<ItensPedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	@PostConstruct
	public void listar() {
		try {

			venda = new Venda();
			venda.setPrecoTotal(new BigDecimal("0.00"));

			ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
			itenspedidos = itenspedidoDAO.listar();

			itenspedido = new ItensPedido();

			itensVenda = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}

	public void adicionar(ActionEvent evento) {
		ItensPedido produto = (ItensPedido) evento.getComponent().getAttributes().get("produtoSelecionado");

		int achou = -1;

		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getItenspedido().equals(produto)) {
				achou = posicao;
			}

		}

		if (achou < 0) {

			ItemVenda itemvenda = new ItemVenda();

			itemvenda.setPrecoParcial(produto.getValor_parcial());
			itemvenda.setItenspedido(produto);
			itemvenda.setQuantidade(new Short("1"));

			itensVenda.add(itemvenda);

		} else {

			ItemVenda itemVenda = itensVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setPrecoParcial(produto.getValor_parcial().multiply(new BigDecimal(itemVenda.getQuantidade())));

		}

		calcular();

	}

	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("itemSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getItenspedido().equals(itemVenda.getItenspedido())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			itensVenda.remove(achou);
		}

		calcular();
	}

	public void calcular() {

		venda.setPrecoTotal(new BigDecimal("0.00"));

		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {

			ItemVenda itemVenda = itensVenda.get(posicao);
			venda.setPrecoTotal(venda.getPrecoTotal().add(itemVenda.getPrecoParcial()));

		}

	}

	public void finalizar() {

		try {
			
			venda.setCliente(null);
			venda.setHorario(new Date());

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			if (venda.getPrecoTotal().signum() == 0) {
				Messages.addGlobalError("Informe pelo menos um item para a venda");
				return;
			}

			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda, itensVenda);
			
			listar();

			Messages.addGlobalInfo("Venda realizada com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a venda");
			erro.printStackTrace();
		}

	}
}