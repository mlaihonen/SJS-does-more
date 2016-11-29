/*package fi.sjs.domore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.sjs.domore.bean.Kayttaja;

//@Transactional
//@Repository("KayttajaDAOHibernate")
//public class KayttajaDAOHibernateImpl implements KayttajaDAO{
	
//tätä ei ainakaan vielä tarvita!

	//@PersistenceContext
    //private EntityManager em;
     
    public void lisaaUusi(Kayttaja kayttaja, int t_id) {
        em.persist(kayttaja);
    }
	
    public List<Kayttaja> haeKaikki() {
		return em.createQuery("select kayttaja from KayttajaImpl kayttaja", Kayttaja.class).getResultList();
	}

//}
*/