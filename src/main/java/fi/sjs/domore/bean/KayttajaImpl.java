package fi.sjs.domore.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//@Entity
//@Table(name = "kayttaja")
public class KayttajaImpl implements Kayttaja{
	
	//@Column(name="etunimi")
	@Size(min = 1, max = 50)
	private String etunimi;
	
	//@Column(name="sukunimi")
	@Size(min = 1, max = 50)
	private String sukunimi;
	
	//@Column(name="kuvaus")
	@Size(min = 0, max = 500)
	private String kuvaus;
	
	//@Column(name="sposti")
	@Size(min = 1, max = 30)
	@Email
	private String sposti;
	
	//@Column(name="puh")
	//@Pattern(regexp = "\\d\\-\\+{7,13}")
	private String puh;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="id")
	private int id;

	public KayttajaImpl() {
		super();
		
	}

	public KayttajaImpl(int id, String etunimi, String sukunimi,
			String kuvaus, String sposti, String puh) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.kuvaus = kuvaus;
		this.sposti = sposti;
		this.puh = puh;
	}

	public KayttajaImpl(String etunimi, String sukunimi, String kuvaus,
			String sposti, String puh, int id) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.kuvaus = kuvaus;
		this.sposti = sposti;
		this.puh = puh;
		this.id = id;
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
		return "KayttajaImpl [etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", kuvaus=" + kuvaus + ", sposti=" + sposti + ", puh=" + puh
				+ ", id=" + id +"]";
	}	
	
}
