package fi.sjs.domore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.sjs.domore.bean.Tapahtuma;

@Transactional
@Repository("hibernateToteutus")
public class TapahtumaDAOHibernateImpl implements TapahtumaDAO{

	@PersistenceContext
	private EntityManager em;
	
	public List<Tapahtuma> haeKaikki() {
		return em.createQuery("select tapahtuma from TapahtumaImpl tapahtuma", Tapahtuma.class).getResultList();
	}

}
