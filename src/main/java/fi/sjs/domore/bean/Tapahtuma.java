package fi.sjs.domore.bean;

import java.util.Date;
import java.util.List;

public interface Tapahtuma {
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getNimi();
	
	public abstract void setNimi(String nimi);
	
	public abstract String getKuvaus();
	
	public abstract void setKuvaus(String kuvaus);
	
	public abstract Date getPvm();
	
	public abstract void setPvm(Date pvm);
	
	public abstract Date getAika();
	
	public abstract void setAika(Date aika);
	
	public abstract String getPaikka();
	
	public abstract void setPaikka(String paikka);
	
	public abstract List<Kayttaja> getOsallistujat();
	
	public abstract void setOsallistujat(List<Kayttaja> osallistujat);
	
	public abstract int getMaxOsallistujaLkm();
	
	public abstract void setMaxOsallistujaLkm(int maxOsallistujaLkm);
	
	public abstract Kayttaja getKayttaja();

	public abstract void setKayttaja(Kayttaja kayttaja);

}
