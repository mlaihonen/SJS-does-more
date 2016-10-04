package fi.sjs.domore.bean;

public class Kayttaja {

	private int id;
	private String etunimi;
	private String sukunimi;
	private int ika;
	private String kuvaus;
	private String sposti;
	private String puh;
	
	

	public Kayttaja() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Kayttaja(int id, String etunimi, String sukunimi, int ika,
			String kuvaus, String sposti, String puh) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.ika = ika;
		this.kuvaus = kuvaus;
		this.sposti = sposti;
		this.puh = puh;
	}



	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getEtunimi() {
		return etunimi;
	}





	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}





	public String getSukunimi() {
		return sukunimi;
	}





	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}





	public int getIka() {
		return ika;
	}





	public void setIka(int ika) {
		this.ika = ika;
	}





	public String getKuvaus() {
		return kuvaus;
	}





	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}





	public String getSposti() {
		return sposti;
	}





	public void setSposti(String sposti) {
		this.sposti = sposti;
	}





	public String getPuh() {
		return puh;
	}





	public void setPuh(String puh) {
		this.puh = puh;
	}





	@Override
	public String toString() {
		return "Kayttaja [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", ika=" + ika + ", kuvaus=" + kuvaus
				+ ", sposti=" + sposti + ", puh=" + puh + "]";
	}
	
	
	
}
