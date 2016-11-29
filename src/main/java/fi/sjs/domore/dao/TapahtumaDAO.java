package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;

public interface TapahtumaDAO {
	
	public abstract void lisaaUusi(Tapahtuma tap);
	
	public abstract List<Tapahtuma> haeKaikki();
	
	public abstract Tapahtuma etsi(int id);
	
	public abstract List<Kayttaja> haeOsallistujat();
	
}
