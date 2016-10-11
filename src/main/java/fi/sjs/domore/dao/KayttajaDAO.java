package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;

public interface KayttajaDAO {
	
	public abstract void lisaaUusi(Kayttaja k);
	
	public abstract List<Kayttaja> haeKaikki();
	
}
