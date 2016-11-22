package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;

public interface KayttajaDAO {
	
	public abstract void lisaaUusi(Kayttaja k, int t_id);
	
	 public abstract List<Kayttaja> haeKaikki();
	 
	 public abstract List<Kayttaja> haeJarjestajat();

} 
