package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Cidade;
import br.com.coleta.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	public void salvar() {

		Long codigo = 3L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		Pessoa pessoa = new Pessoa();

		pessoa.setCelular("84417847");
		pessoa.setCep("69488-412");
		pessoa.setComplemento("Atras");
		pessoa.setCpf_cnpj("54542154514");
		pessoa.setEmail("kaducouch@gmail.com");
		pessoa.setNome("Kadu da Silva");
		pessoa.setNumero(new Short("8847"));
		pessoa.setRua("Itamaratir");
		pessoa.setTelefone("32298854");
		pessoa.setCidade(cidade);

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

	}

	@Test
	@Ignore
	public void listar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		for (Pessoa pessoa : resultado) {
			System.out.println("----------Dados Pessoais-------- ");
			System.out.println("Codigo: " + pessoa.getCodigo());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println("----------Dados Cadastrais-------- ");
			System.out.println("Numero Residencia: " + pessoa.getNumero());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Telefone Residencial:" + pessoa.getTelefone());
			System.out.println("Telefone Celular:" + pessoa.getCelular());
			System.out.println("Codigo da Cidade: " + pessoa.getCidade().getCodigo());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());
			System.out.println("Estado: " + pessoa.getCidade().getEstado().getNome());
		}

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 3L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		System.out.println("----------Dados Pessoais-------- ");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
		System.out.println("Email: " + pessoa.getEmail());
		System.out.println("----------Dados Cadastrais-------- ");
		System.out.println("Numero Residencia: " + pessoa.getNumero());
		System.out.println("Rua: " + pessoa.getRua());
		System.out.println("CEP: " + pessoa.getCep());
		System.out.println("Complemento: " + pessoa.getComplemento());
		System.out.println("Telefone Residencial:" + pessoa.getTelefone());
		System.out.println("Telefone Celular:" + pessoa.getCelular());
		System.out.println("Codigo da Cidade: " + pessoa.getCidade().getCodigo());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		System.out.println("Estado: " + pessoa.getCidade().getEstado().getNome());

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		pessoaDAO.excluir(pessoa);

		System.out.println("Dados Removidos");
		System.out.println("----------Dados Pessoais-------- ");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
		System.out.println("Email: " + pessoa.getEmail());
		System.out.println("----------Dados Cadastrais-------- ");
		System.out.println("Numero Residencia: " + pessoa.getNumero());
		System.out.println("Rua: " + pessoa.getRua());
		System.out.println("CEP: " + pessoa.getCep());
		System.out.println("Complemento: " + pessoa.getComplemento());
		System.out.println("Telefone Residencial:" + pessoa.getTelefone());
		System.out.println("Telefone Celular:" + pessoa.getCelular());
		System.out.println("Codigo da Cidade: " + pessoa.getCidade().getCodigo());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		System.out.println("Estado: " + pessoa.getCidade().getEstado().getNome());

	}

	@Test
	@Ignore
	public void editar() {

		Long codigoCidade = 1L;
		Long codigoPessoa = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		System.out.println("Codigo da Cidade: " + cidade.getCodigo());
		System.out.println("Cidade: " + cidade.getNome());
		System.out.println("Estado: " + cidade.getEstado().getNome());

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		System.out.println("Dados a Serem Editados");
		System.out.println("----------Dados Pessoais-------- ");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
		System.out.println("Email: " + pessoa.getEmail());
		System.out.println("----------Dados Cadastrais-------- ");
		System.out.println("Numero Residencia: " + pessoa.getNumero());
		System.out.println("Rua: " + pessoa.getRua());
		System.out.println("CEP: " + pessoa.getCep());
		System.out.println("Complemento: " + pessoa.getComplemento());
		System.out.println("Telefone Residencial:" + pessoa.getTelefone());
		System.out.println("Telefone Celular:" + pessoa.getCelular());
		System.out.println("Codigo da Cidade: " + pessoa.getCidade().getCodigo());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		System.out.println("Estado: " + pessoa.getCidade().getEstado().getNome());

		pessoa.setNome("João Pedro Carvalho");
		pessoa.setCelular("64689214");
		pessoa.setCidade(cidade);

		pessoaDAO.editar(pessoa);

	}

}
