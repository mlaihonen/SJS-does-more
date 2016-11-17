package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.FormFrankenstein;
import fi.sjs.domore.bean.Tapahtuma;

public interface TapahtumaDAO {
	
	public abstract void lisaaUusi(Tapahtuma tapahtuma);
	
	public abstract void lisaaUusiFrankenstein(FormFrankenstein frank);
	
	public abstract void lisaaUusiTapahtumaKayttajalla(Tapahtuma tap);
	
	public abstract List<Tapahtuma> haeKaikki();
	
	public abstract Tapahtuma etsi(int id);
	
}
