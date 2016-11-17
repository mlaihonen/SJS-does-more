package fi.sjs.domore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.sjs.domore.bean.FormFrankenstein;
import fi.sjs.domore.bean.Tapahtuma;

@Transactional
@Repository("TapahtumaDAOHibernate")
public class TapahtumaDAOHibernateImpl implements TapahtumaDAO{

	@PersistenceContext
	private EntityManager em;
	
	public void lisaaUusi(Tapahtuma tapahtuma) {
		em.persist(tapahtuma);
    }
	
	//Palauttaa listan tulevista tapahtumista järjestyksessä
	public List<Tapahtuma> haeKaikki() {	
		return em.createQuery("select tapahtuma from TapahtumaImpl tapahtuma " + 
				"where date(tapahtuma.pvm) >= current_date "+
				"order by tapahtuma.pvm asc, tapahtuma.aika asc", Tapahtuma.class)
				.getResultList();		
	}

	public Tapahtuma etsi(int id) {
		  return em.createQuery("select tapahtuma from TapahtumaImpl tapahtuma "
	        		+ "where id ="+id, Tapahtuma.class).getSingleResult();
	}
	
	public void lisaaUusiFrankenstein(FormFrankenstein frank){
		
	}

}
