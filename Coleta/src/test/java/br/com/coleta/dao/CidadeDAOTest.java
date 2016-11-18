package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Cidade;
import br.com.coleta.domain.Estado;

public class CidadeDAOTest {

	@Test
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(1L);

		Cidade cidade = new Cidade();
		cidade.setNome("Rio Branco");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " /" + cidade.getEstado().getNome()
					+ " -" + cidade.getEstado().getSigla());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " /" + cidade.getEstado().getNome() + " -"
				+ cidade.getEstado().getSigla());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		
		System.out.println("Cidade Removida: ");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " /" + cidade.getEstado().getNome() + " -"
				+ cidade.getEstado().getSigla());
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		
		Long codigoEstado = 7L;
		Long codigoCiade  = 3L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		System.out.println("Codigo do Estado:" + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCiade);
		
		System.out.println("Cidade a ser editada: ");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " /" + cidade.getEstado().getNome() + " -"
				+ cidade.getEstado().getSigla());
		
		cidade.setNome("Guarapuava");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		System.out.println("Cidade editada: ");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " /" + cidade.getEstado().getNome() + " -"
				+ cidade.getEstado().getSigla());
		
	}

}
