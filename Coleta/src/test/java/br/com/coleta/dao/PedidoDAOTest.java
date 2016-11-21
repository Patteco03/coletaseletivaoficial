package br.com.coleta.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Cliente;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Pedido;

public class PedidoDAOTest {

	@Test
	public void salvar() {

		Long codigoCliente = 1L;
		Long codigoItensPedido = 1L;

		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		ItensPedido itenspedido = itenspedidoDAO.buscar(codigoItensPedido);

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		Pedido pedido = new Pedido();
		pedido.setPreco_total(new BigDecimal("120.00"));
		pedido.setDescricao("Dinheiro em especie");
		pedido.setDataPedido(new Date(11 / 11 / 2016));
		pedido.setCliente(cliente);
		pedido.setItenspedido(itenspedido);

		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.salvar(pedido);

	}

	@Test
	@Ignore
	public void listar() {

		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> resultado = pedidoDAO.listar();

		for (Pedido pedido : resultado) {

			System.out.println("-----------Item Pedido----------");
			System.out.println("Nome do Produto: " + pedido.getItenspedido().getProduto().getNome());
			System.out.println("Nome do Cliente-Vendedor: " + pedido.getCliente().getPessoa().getNome());
			System.out.println("Data da Venda: " + pedido.getDataPedido());

		}

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigo);

		System.out.println("-----------Item Pedido----------");
		System.out.println("Nome do Produto: " + pedido.getItenspedido().getProduto().getNome());
		System.out.println("Nome do Cliente-Vendedor: " + pedido.getCliente().getPessoa().getNome());
		System.out.println("Data da Venda: " + pedido.getDataPedido());

	}

	@Test
	@Ignore
	public void editar() {

		Long codigoIten = 1L;
		Long codigoPedido = 1L;

		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		ItensPedido itenspedido = itenspedidoDAO.buscar(codigoIten);

		System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
		System.out.println("Peso  do Iten: " + itenspedido.getPeso());
		System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
		System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());
		System.out.println(" ----------------------------------------");
		System.out.println("Codigo do Produto: " + itenspedido.getProduto().getCodigo());
		System.out.println("Nome do Produto: " + itenspedido.getProduto().getNome());

		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigoPedido);

		System.out.println("-----------Pedido a ser Editado----------");
		System.out.println("Nome do Produto: " + pedido.getItenspedido().getProduto().getNome());
		System.out.println("Nome do Cliente-Vendedor: " + pedido.getCliente().getPessoa().getNome());
		System.out.println("Data da Venda: " + pedido.getDataPedido());

		pedido.setDescricao("Pagamento em Cartão");
		pedido.setItenspedido(itenspedido);

		pedidoDAO.editar(pedido);

		System.out.println("-----------Pedido Editado----------");
		System.out.println("Nome do Produto: " + pedido.getItenspedido().getProduto().getNome());
		System.out.println("Nome do Cliente-Vendedor: " + pedido.getCliente().getPessoa().getNome());
		System.out.println("Data da Venda: " + pedido.getDataPedido());
		System.out.println("Forma de Pagamento: " + pedido.getDescricao());

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigoPedido = 1L;

		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.buscar(codigoPedido);

		pedidoDAO.excluir(pedido);

		System.out.println("----------Pedido Excluido com Sucesso----------");
		System.out.println("Nome do Produto: " + pedido.getItenspedido().getProduto().getNome());
		System.out.println("Nome do Cliente-Vendedor: " + pedido.getCliente().getPessoa().getNome());
		System.out.println("Data da Venda: " + pedido.getDataPedido());
		System.out.println("Forma de Pagamento: " + pedido.getDescricao());

	}

}
