package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.coleta.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() {
		Produto produto = new Produto();
		produto.setNome("Latinhas de Cerveja");
		produto.setDescricao("Em varios sacos plastico");

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println(produto.getNome() + " - " + produto.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.out.println(produto.getNome() + " - " + produto.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Registro Removido");
			System.out.println(produto.getNome() + " - " + produto.getDescricao());
		}

	}

	@Test
	@Ignore
	public void Editar() {
		Long codigo = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes: ");
			System.out.println(produto.getNome() + " - " + produto.getDescricao());

			produto.setNome("Cobre");
			produto.setDescricao(" Varios");
			produtoDAO.editar(produto);

			System.out.println("Registro editado - Depois: ");
			System.out.println(produto.getNome() + " - " + produto.getDescricao());
		}

	}

}
