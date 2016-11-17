package fi.sjs.domore.bean;

public class FormFrankenstein{
	
	public Kayttaja kayttaja;
	public Tapahtuma tapahtuma;
	
	public FormFrankenstein() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormFrankenstein(Kayttaja kayttaja, Tapahtuma tapahtuma) {
		super();
		this.kayttaja = kayttaja;
		this.tapahtuma = tapahtuma;
	}

	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}
	
	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
	}
	
	public Kayttaja getKayttaja() {
		return kayttaja;
	}
	
	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}
	
}
