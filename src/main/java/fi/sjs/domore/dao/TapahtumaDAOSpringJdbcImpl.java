package fi.sjs.domore.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void lisaaUusi(Tapahtuma tap) {
		System.out.println(tap);
	
		final String sql = "insert into tapahtuma (t_nimi, t_kuvaus, t_pvm, t_aika, t_paikka, t_maxosallistujalkm) VALUES (?,?,?,?,?,?)";
				
		java.sql.Date sqlDate = new java.sql.Date(tap.getPvm().getTime());
		java.sql.Date sqlTime = new java.sql.Date(tap.getAika().getTime());   
	   
		final String tNimi = tap.getNimi();
		final String tKuvaus = tap.getKuvaus();
		final Date pvm = sqlDate;
		final Date aika = sqlTime;
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
				ps.setDate(4, aika);
				ps.setString(5, paikka);
				ps.setInt(6, maxOsall);
				return ps;
			}
		}, idHolder);
		
		tap.setId(idHolder.getKey().intValue());	
	
	}
	
	public  List<Tapahtuma> haeKaikki(){
		return null;
		
	}
	
	public Tapahtuma etsi(int id){
		return null;
		
	}

}
