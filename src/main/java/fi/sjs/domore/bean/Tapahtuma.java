package fi.sjs.domore.bean;

import java.util.Date;

public class Tapahtuma {
	
	private int id;
	private String nimi;
	private String kuvaus;
	private Date pvm;
	private Date aika;
	private String paikka;
	//private int osallistujalkm;
	//private int jarjestajaId;
	//private String kategoria;
	
	public Tapahtuma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tapahtuma(int id, String nimi, String kuvaus, Date pvm, Date aika,
			String paikka) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.pvm = pvm;
		this.aika = aika;
		this.paikka = paikka;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String getKuvaus() {
		return kuvaus;
	}
	
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	
	public Date getPvm() {
		return pvm;
	}
	
	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}
	public Date getAika() {
		return aika;
	}
	public void setAika(Date aika) {
		this.aika = aika;
	}
	
	public String getPaikka() {
		return paikka;
	}
	
	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}
	
	@Override
	public String toString() {
		return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus
				+ ", pvm=" + pvm + ", aika=" + aika + ", paikka=" + paikka
				+ "]";
	}
		
}
