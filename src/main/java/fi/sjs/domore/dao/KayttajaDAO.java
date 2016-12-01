package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;

public interface KayttajaDAO {
	
	public abstract boolean lisaaUusi(Kayttaja k, int t_id);
	 
	// public abstract List<Kayttaja> haeJarjestajat();

} 
