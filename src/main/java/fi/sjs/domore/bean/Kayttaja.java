package fi.sjs.domore.bean;

public interface Kayttaja {
	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getEtunimi();

	public abstract void setEtunimi(String etunimi);

	public abstract String getSukunimi();
	
	public abstract void setSukunimi(String sukunimi);
	
	public abstract String getKuvaus();
	
	public abstract void setKuvaus(String kuvaus);
	
	public abstract String getSposti();
	
	public abstract void setSposti(String sposti);
	
	public abstract String getPuh();
	
	public abstract void setPuh(String puh);
}
