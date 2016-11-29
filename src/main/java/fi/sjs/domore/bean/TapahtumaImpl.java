package fi.sjs.domore.bean;


import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	//@Entity
	//@Table(name = "tapahtuma")
	public class TapahtumaImpl implements Tapahtuma{
		
		//@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		//@Column(name = "id")
		private int id;
		
		//@Column(name = "nimi")
		@Size(min = 1, max = 50)
		@NotNull
		private String nimi;
		
		//@Column(name = "kuvaus")
		@Size(min = 1, max = 500)
		private String kuvaus;
		
		//@Column(name = "pvm")
		//@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="dd.MM.yyyy")
		@NotNull
		private Date pvm;
		
		//@Column(name = "aika")
		//@Temporal(TemporalType.TIME)
		@DateTimeFormat(pattern="HH:mm")
		@NotNull
		private Date aika;
		
		//@Column(name = "paikka")
		@Size(min = 1, max = 50)
		private String paikka;
				
		//@Column(name = "maxosallistujalkm")
		private int maxOsallistujaLkm;
			
		
		/*@ManyToMany(targetEntity = fi.sjs.domore.bean.KayttajaImpl.class, 
				fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(
				name = "tapahtumaosallistuja",
				joinColumns = @JoinColumn(name = "t_id"),
				inverseJoinColumns = @JoinColumn(name = "k_id"))*/
		private List<Kayttaja> osallistujat;
		
		private Kayttaja kayttaja = new KayttajaImpl();
		
		public TapahtumaImpl() {
			super();
		}
		
		public TapahtumaImpl(Kayttaja kayttaja) {
			this.kayttaja = kayttaja;
		}

		public TapahtumaImpl(int id, String nimi, String kuvaus, Date pvm,
				Date aika, String paikka,
				int maxOsallistujaLkm, List<Kayttaja> osallistujat) {
			super();
			this.id = id;
			this.nimi = nimi;
			this.kuvaus = kuvaus;
			this.pvm = pvm;
			this.aika = aika;
			this.paikka = paikka;
			this.maxOsallistujaLkm = maxOsallistujaLkm;
			this.osallistujat = osallistujat;
		}

		public TapahtumaImpl(int id, String nimi, String kuvaus, Date pvm,
				Date aika, String paikka,
				int maxOsallistujaLkm, List<Kayttaja> osallistujat,
				Kayttaja kayttaja) {
			super();
			this.id = id;
			this.nimi = nimi;
			this.kuvaus = kuvaus;
			this.pvm = pvm;
			this.aika = aika;
			this.paikka = paikka;
			this.maxOsallistujaLkm = maxOsallistujaLkm;
			this.osallistujat = osallistujat;
			this.kayttaja = kayttaja;
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

		public int getMaxOsallistujaLkm() {
			return maxOsallistujaLkm;
		}
		
		public void setMaxOsallistujaLkm(int maxOsallistujaLkm) {
			this.maxOsallistujaLkm = maxOsallistujaLkm;
		}

		public List<Kayttaja> getOsallistujat() {
			return osallistujat;
		}

		public void setOsallistujat(List<Kayttaja> osallistujat) {
			this.osallistujat = osallistujat;		
		}
		
		public int getOsallistujaLkm() {
			//int osallistujaLkm = osallistujat.size();
			return 0;
		}
	
		//@ManyToOne(cascade=CascadeType.ALL, targetEntity = fi.sjs.domore.bean.KayttajaImpl.class) 
		public Kayttaja getKayttaja() {
			return kayttaja;
		}

		public void setKayttaja(Kayttaja kayttaja) {
			this.kayttaja = kayttaja;
		}

		@Override
		public String toString() {
			return "TapahtumaImpl [id=" + id + ", nimi=" + nimi + ", kuvaus="
					+ kuvaus + ", pvm=" + pvm + ", aika=" + aika + ", paikka="
					+ paikka 
					+ ", maxOsallistujaLkm=" + maxOsallistujaLkm
					+ ", osallistujat=" + osallistujat + "]";
		}
			
	}
		

