package br.com.coleta.main;

import org.hibernate.Session;

import br.com.coleta.util.HibernateUtil;



public class HibernateUtilTeste {
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}