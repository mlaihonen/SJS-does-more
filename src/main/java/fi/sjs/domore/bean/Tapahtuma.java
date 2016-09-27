package fi.sjs.domore.bean;

import java.util.Date;

public class Tapahtuma {
	
	private int tId;
	private String tNimi;
	private String tKuvaus;
	private Date tPvm;
	private Date tAika;
	private String tPaikka;
	//private int tOsallistujalkm;
	//private int tJarjestajaId;
	//private String tKategoria;
	
	public Tapahtuma() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tapahtuma(int tId, String tNimi, String tKuvaus, Date tPvm,
			Date tAika, String tPaikka) {
		super();
		this.tId = tId;
		this.tNimi = tNimi;
		this.tKuvaus = tKuvaus;
		this.tPvm = tPvm;
		this.tAika = tAika;
		this.tPaikka = tPaikka;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettNimi() {
		return tNimi;
	}
	public void settNimi(String tNimi) {
		this.tNimi = tNimi;
	}
	public String gettKuvaus() {
		return tKuvaus;
	}
	public void settKuvaus(String tKuvaus) {
		this.tKuvaus = tKuvaus;
	}
	public Date gettPvm() {
		return tPvm;
	}
	public void settPvm(Date tPvm) {
		this.tPvm = tPvm;
	}
	public Date gettAika() {
		return tAika;
	}
	public void settAika(Date tAika) {
		this.tAika = tAika;
	}
	public String gettPaikka() {
		return tPaikka;
	}
	public void settPaikka(String tPaikka) {
		this.tPaikka = tPaikka;
	}
	@Override
	public String toString() {
		return "Tapahtuma [tId=" + tId + ", tNimi=" + tNimi + ", tKuvaus="
				+ tKuvaus + ", tPvm=" + tPvm + ", tAika=" + tAika
				+ ", tPaikka=" + tPaikka + "]";
	}
	
}
