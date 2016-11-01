package fi.sjs.domore.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name = "tapahtuma")
	public class TapahtumaImpl implements Tapahtuma{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "t_id")
		private int id;
		
		@Column(name = "t_nimi")
		private String nimi;
		
		@Column(name = "t_kuvaus")
		private String kuvaus;
		
		@Column(name = "t_pvm")
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="dd.MM.yyyy")
		private Date pvm;
		
		@Column(name = "t_aika")
		@Temporal(TemporalType.TIME)
		@DateTimeFormat(pattern="HH:mm")
		private Date aika;
		
		@Column(name = "t_paikka")
		private String paikka;
		
		@ManyToMany(targetEntity = fi.sjs.domore.bean.KayttajaImpl.class, 
				fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(
				name = "tapahtumaosallistuja",
				joinColumns = @JoinColumn(name = "t_id"),
				inverseJoinColumns = @JoinColumn(name = "k_id"))
		private List<Kayttaja> osallistujat;
		
		public TapahtumaImpl() {
			super();
		}

		public TapahtumaImpl(int id, String nimi, String kuvaus, Date pvm, Date aika,
				String paikka, List<Kayttaja> osallistujat) {
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

		public List<Kayttaja> getOsallistujat() {
			return osallistujat;
		}

		public void setOsallistujat(List<Kayttaja> osallistujat) {
			this.osallistujat = osallistujat;		
		}
		
		@Override
		public String toString() {
			return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus
					+ ", pvm=" + pvm + ", aika=" + aika + ", paikka=" + paikka
					+ ", osallistujat=" + osallistujat + "]";
		}
			
	}
		

