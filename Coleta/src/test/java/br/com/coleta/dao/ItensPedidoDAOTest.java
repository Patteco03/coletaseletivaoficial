package br.com.coleta.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;

public class ItensPedidoDAOTest {

	@Test
	public void salvar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		ItensPedido itenspedido = new ItensPedido();
		itenspedido.setPeso(new Float(100));
		itenspedido.setQuantidade(new Integer("50"));
		itenspedido.setValor_parcial(new BigDecimal("13.30"));
		itenspedido.setProduto(produto);

		ItensPedidoDAO itensprodutoDAO = new ItensPedidoDAO();
		itensprodutoDAO.salvar(itenspedido);

		System.out.println("Produto Salvo com sucesso:");

	}

	@Test
	@Ignore
	public void listar() {

		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		List<ItensPedido> resultado = itenspedidoDAO.listar();

		System.out.println("Total de Registros Enontrados: " + resultado.size());

		for (ItensPedido itenspedido : resultado) {

			System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
			System.out.println("Peso  do Iten: " + itenspedido.getPeso());
			System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
			System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());
			System.out.println(" ----------------------------------------");
			System.out.println("Codigo do Produto: " + itenspedido.getProduto().getCodigo());
			System.out.println("Nome do Produto: " + itenspedido.getProduto().getNome());
		}
	}
	
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 3L;
		
		ItensPedidoDAO itensprodutoDAO = new ItensPedidoDAO();
		ItensPedido itenspedido = itensprodutoDAO.buscar(codigo);
		
		System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
		System.out.println("Peso  do Iten: " + itenspedido.getPeso());
		System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
		System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());
		System.out.println(" ----------------------------------------");
		System.out.println("Codigo do Produto: " + itenspedido.getProduto().getCodigo());
		System.out.println("Nome do Produto: " + itenspedido.getProduto().getNome());
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoProduto = 2L;
		Long Codigoitenspedido = 3L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		System.out.println("Codigo do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getNome());
		
		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		ItensPedido itenspedido = itenspedidoDAO.buscar(Codigoitenspedido);
		
		System.out.println("Itens Pedido a ser Editado: ");
		System.out.println("Codigo do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getNome());
		System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
		System.out.println("Peso  do Iten: " + itenspedido.getPeso());
		System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
		System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());
		
		itenspedido.setPeso(new Float(200));
		itenspedido.setQuantidade(new Integer("10"));
		itenspedido.setValor_parcial(new BigDecimal("3.80"));
		itenspedido.setProduto(produto);
		
		itenspedidoDAO.editar(itenspedido);
		
		System.out.println("Itens Pedido  Editado: ");
		System.out.println("Codigo do Produto: " + produto.getCodigo());
		System.out.println("Nome do Produto: " + produto.getNome());
		System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
		System.out.println("Peso  do Iten: " + itenspedido.getPeso());
		System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
		System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());

		
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 3L;
		
		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		ItensPedido itenspedido = itenspedidoDAO.buscar(codigo);
		
		itenspedidoDAO.excluir(itenspedido);
		
		System.out.println("Item Removido");
		System.out.println("Codigo do Iten: " + itenspedido.getCodigo());
		System.out.println("Peso  do Iten: " + itenspedido.getPeso());
		System.out.println("Quantidade Itens: " + itenspedido.getQuantidade());
		System.out.println("Valor-Parcial  do Iten: " + itenspedido.getValor_parcial());
		System.out.println(" ----------------------------------------");
		System.out.println("Codigo do Produto: " + itenspedido.getProduto().getCodigo());
		System.out.println("Nome do Produto: " + itenspedido.getProduto().getNome());
		
	}

}
