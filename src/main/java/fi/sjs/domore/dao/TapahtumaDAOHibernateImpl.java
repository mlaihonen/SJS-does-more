package fi.sjs.domore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.sjs.domore.bean.Tapahtuma;

@Transactional
@Repository("TapahtumaDAOHibernate")
public class TapahtumaDAOHibernateImpl implements TapahtumaDAO{

	@PersistenceContext
	private EntityManager em;
	
	public void lisaaUusi(Tapahtuma tapahtuma) {
		em.persist(tapahtuma);
    }
	
	public List<Tapahtuma> haeKaikki() {
		return em.createQuery("select tapahtuma from TapahtumaImpl tapahtuma", Tapahtuma.class).getResultList();
	}

	public Tapahtuma etsi(int id) {
		  return em.createQuery("select tapahtuma from TapahtumaImpl tapahtuma "
	        		+ "where id ="+id, Tapahtuma.class).getSingleResult();
	}

}
