package fi.sjs.domore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
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
	
	public int lisaaUusi(Tapahtuma tap) {
		
		final String sql = "INSERT INTO kayttaja(etunimi, sukunimi, bio, sposti, puh) VALUES (?,?,?,?,?)";
		
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
		int id = tap.getKayttaja().getId();
		return id;
	
	}
	
	public  List<Tapahtuma> haeKaikki(){
		final String sql = "SELECT t.tapahtumaid, t.nimi, t.kuvaus, t.pvm, t.aika, t.paikka, t.maxosallistujalkm, t.jarjestaja_id, k.kayttajaid, k.etunimi, k.sukunimi, k.bio, k.sposti, k.puh" 
							+ " FROM tapahtuma t" 
							+ " LEFT JOIN kayttaja k" 
							+ " ON k.kayttajaid = t.jarjestaja_id;";
		
		List<Tapahtuma> tapahtumat = jdbcTemplate.query(sql, new TapahtumaRowMapper());	
		return tapahtumat;	
	}
	
	
	public List<Kayttaja> haeOsallistujat( int tId) {
			
		final String sql = "select k.kayttajaid, k.etunimi, k.sukunimi, k.bio, k.sposti, k.puh"
							+ " FROM kayttaja k"
							+ " JOIN tapahtumaosallistuja o"
							+ " ON k.kayttajaid = o.k_id"
							+ " JOIN tapahtuma t"
							+ " ON t.tapahtumaid = o.t_id"
							+ " WHERE o.t_id = ?;";

		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		Object[] id = new Object[] { tId };
		List<Kayttaja> osallistujat  = jdbcTemplate.query(sql,
				id, mapper);
		System.out.println(osallistujat);
		return osallistujat;
	}
	
	public Tapahtuma etsi(int id){
		final String sql = "SELECT t.tapahtumaid, t.nimi, t.kuvaus, t.pvm, t.aika, t.paikka, t.maxosallistujalkm, t.jarjestaja_id, k.kayttajaid, k.etunimi, k.sukunimi, k.bio, k.sposti, k.puh" 
						+ " FROM tapahtuma t" 
						+ " LEFT JOIN kayttaja k" 
						+ " ON k.kayttajaid = t.jarjestaja_id"
						+ " WHERE t.tapahtumaid = ?;";
		Object[] parametrit = new Object[] { id };
		RowMapper<Tapahtuma> mapper = new TapahtumaRowMapper();
		Tapahtuma tapahtuma = jdbcTemplate.queryForObject(sql , parametrit, mapper);
	
		return tapahtuma;	
	}

}
