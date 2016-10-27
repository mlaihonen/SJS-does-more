package fi.sjs.domore.bean;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Tapahtuma {
	
	private int id;
	private String nimi;
	private String kuvaus;
	@DateTimeFormat(pattern="dd.MM.yyyy")
	private Date pvm;
	@DateTimeFormat(pattern="HH:mm")
	private Date aika;
	private String paikka;
	private ArrayList<Kayttaja> osallistujat;
	//private int osallistujalkm;
	//private int jarjestajaId;
	//private String kategoria;
	
	public Tapahtuma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tapahtuma(int id, String nimi, String kuvaus, Date pvm, Date aika,
			String paikka, ArrayList<Kayttaja> osallistujat) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.pvm = pvm;
		this.aika = aika;
		this.paikka = paikka;
		this.osallistujat = osallistujat;
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

	public ArrayList<Kayttaja> getOsallistujat() {
		return osallistujat;
	}

	public void setOsallistujat(ArrayList<Kayttaja> osallistujat) {
		this.osallistujat = osallistujat;
	}

	@Override
	public String toString() {
		return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus
				+ ", pvm=" + pvm + ", aika=" + aika + ", paikka=" + paikka
				+ ", osallistujat=" + osallistujat + "]";
	}
		
}
