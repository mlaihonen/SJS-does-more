package fi.sjs.domore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;

@Transactional
@Repository("TapahtumaDAOSpring")
public class TapahtumaDAOSpringJdbcImpl implements TapahtumaDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*public void lisaaUusiIlmanKayttajaa(Tapahtuma tap) {
	
		final String sql = "insert into tapahtuma (nimi, kuvaus, pvm, aika, paikka, maxosallistujalkm) VALUES (?,?,?,?,?,?)";
				
		java.sql.Date sqlDate = new java.sql.Date(tap.getPvm().getTime());
		java.sql.Time sqlTime = new java.sql.Time(tap.getAika().getTime());   
	   
		final String tNimi = tap.getNimi();
		final String tKuvaus = tap.getKuvaus();
		final Date pvm = sqlDate;
		final Time aika = sqlTime;
		final String paikka = tap.getPaikka();
		final int maxOsall = tap.getMaxOsallistujaLkm();

		// jdbc pist�� generoidun id:n talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
		

		//p�ivitys PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, tNimi);
				ps.setString(2, tKuvaus);
				ps.setDate(3, pvm);
				ps.setTime(4, aika);
				ps.setString(5, paikka);
				ps.setInt(6, maxOsall);
				return ps;
			}
		}, idHolder);
		
		tap.setId(idHolder.getKey().intValue());	
	
	}*/
	
	
	public void lisaaUusi(Tapahtuma tap) {
		
		final String sql = "INSERT INTO kayttaja(etunimi, sukunimi, kuvaus, sposti, puh) VALUES (?,?,?,?,?)";
		
		final String eNimi = tap.getKayttaja().getEtunimi();
		final String sNimi = tap.getKayttaja().getSukunimi();
		final String kuvaus = tap.getKayttaja().getKuvaus();
		final String sPosti = tap.getKayttaja().getSposti();
		final String puh = tap.getKayttaja().getPuh();

		// jdbc pist�� generoidun id:n talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
		

		//p�ivitys PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, eNimi);
				ps.setString(2, sNimi);
				ps.setString(3, kuvaus);
				ps.setString(4, sPosti);
				ps.setString(5, puh);
				return ps;
			}
		}, idHolder);
		
		tap.getKayttaja().setId(idHolder.getKey().intValue());		
		
		final String sql2 = "insert into tapahtuma (nimi, kuvaus, pvm, aika, paikka, jarjestaja_id, maxosallistujalkm) VALUES (?,?,?,?,?,?,?)";
				
		Date sqlDate = new Date(tap.getPvm().getTime());
		Time sqlTime = new Time(tap.getAika().getTime());   
	   
		final String tNimi = tap.getNimi();
		final String tKuvaus = tap.getKuvaus();
		final Date pvm = sqlDate;
		final Time aika = sqlTime;
		final String paikka = tap.getPaikka();
		final int jarjId = tap.getKayttaja().getId();
		final int maxOsall = tap.getMaxOsallistujaLkm();

		// jdbc pist�� generoidun id:n talteen
		KeyHolder idHolder2 = new GeneratedKeyHolder();
		

		//p�ivitys PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql2,
						new String[] { "id" });
				ps.setString(1, tNimi);
				ps.setString(2, tKuvaus);
				ps.setDate(3, pvm);
				ps.setTime(4, aika);
				ps.setString(5, paikka);
				ps.setInt(6, jarjId);
				ps.setInt(7, maxOsall);
				return ps;
			}
		}, idHolder2);
		
		tap.setId(idHolder2.getKey().intValue());	
	
	}
	
	public  List<Tapahtuma> haeKaikki(){
		final String sql = "SELECT t.id, t.nimi, t.kuvaus, t.pvm, t.aika, t.paikka, t.maxosallistujalkm, t.jarjestaja_id, k.id as kid, k.etunimi, k.sukunimi, k.kuvaus as kkuvaus, k.sposti, k.puh" 
							+ " FROM tapahtuma t" 
							+ " LEFT JOIN kayttaja k" 
							+ " ON k.id = t.jarjestaja_id;";
		
		RowMapper<Tapahtuma> mapper = new TapahtumaRowMapper();
		
		List<Tapahtuma> tapahtumat = jdbcTemplate.query(sql,mapper);

		return tapahtumat;
		
	}
	
	public Tapahtuma etsi(int id){
		return null;
		
	}

	public List<Kayttaja> haeOsallistujat( int tId) {
		final String sql = "select k.id, k.etunimi, k.sukunimi, k.kuvaus, k.sposti, k.puh"
							+ " FROM kayttaja k"
							+ " JOIN tapahtumaosallistuja o"
							+ " ON k.id = o.k_id"
							+ " JOIN tapahtuma t"
							+ " ON t.id = o.t_id"
							+ " WHERE o.t_id = ?;";
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			
			ps.setString(1, tNimi);
		
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> osallistujat = jdbc
		return null;
	}

}
