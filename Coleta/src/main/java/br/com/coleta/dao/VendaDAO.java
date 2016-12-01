package br.com.coleta.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.coleta.domain.ItemVenda;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Venda;
import br.com.coleta.util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda> {
	public void salvar(Venda venda, List<ItemVenda> itensVenda){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
		
			sessao.save(venda);
			
			for(int posicao = 0; posicao < itensVenda.size(); posicao++){
				ItemVenda itemVenda = itensVenda.get(posicao);
				itemVenda.setVenda(venda);
				
				sessao.save(itemVenda);
				
				ItensPedido itens =  itemVenda.getItenspedido();
				int qtde = itens.getQuantidade() - itemVenda.getQuantidade();
				
				if(qtde >= 0 ){
					
					itens.setQuantidade(qtde); 
					
					sessao.update(itens);
					
				}else{
					
					throw new RuntimeException("A quantidade insuficiente em estoque!");	
				}
				
			}
			
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}