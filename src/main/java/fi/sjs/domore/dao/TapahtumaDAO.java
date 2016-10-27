package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;

public interface TapahtumaDAO {
	
	public abstract List<Tapahtuma> haeKaikki();
	
	public abstract List<Kayttaja> haeOsallistujat(int t_id);
}
