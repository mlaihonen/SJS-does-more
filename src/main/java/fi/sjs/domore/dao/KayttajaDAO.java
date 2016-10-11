package fi.sjs.domore.dao;

import java.util.List;

import fi.sjs.domore.bean.KayttajaImpl;

public interface KayttajaDAO {
	
	public abstract void lisaaUusi(KayttajaImpl k);
	
	public abstract List<KayttajaImpl> haeKaikki();
	
}
