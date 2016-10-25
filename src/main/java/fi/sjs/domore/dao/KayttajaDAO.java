package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.TapahtumaOsallistuja;

public interface KayttajaDAO {
	
	public abstract void lisaaUusi(Kayttaja k, int t_id);
	
	public abstract List<Kayttaja> haeKaikki();
	
	public abstract List<TapahtumaOsallistuja> haeOsallistujat();

} 
