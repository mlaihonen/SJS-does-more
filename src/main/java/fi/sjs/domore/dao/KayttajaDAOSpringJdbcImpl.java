package fi.sjs.domore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


@Transactional
@Repository("KayttajaDAOSpring")
public class KayttajaDAOSpringJdbcImpl implements KayttajaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//Lisää osallistuja tapahtumaan
	public int lisaaUusi(Kayttaja k, int tId) {
		int lkm = 0;
		final String sql = "SELECT (SELECT maxosallistujalkm FROM tapahtuma WHERE tapahtumaid = ?) -"
						+ " (SELECT COUNT(*) FROM tapahtumaosallistuja WHERE t_id = ?) AS osallistujaLkm;";
		final String sql1 = "INSERT INTO kayttaja (etunimi, sukunimi, sposti, puh) VALUES (?,?,?,?)";
		final String sql2 = "INSERT INTO tapahtumaosallistuja (k_id, t_id) VALUES (?,?)";
		
		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot
		final int tapahtumaid = tId;
		final String etunimi = k.getEtunimi();
		final String sukunimi = k.getSukunimi();
		final String sposti = k.getSposti();
		final String puh = k.getPuh();

		// jdbc pistää generoidun käyttäjä-id:n talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		Object[] parametrit = new Object[] { tId, tId };
		int tyhjatPaikat = jdbcTemplate.queryForObject(sql, parametrit, Integer.class);
		System.out.println("TYHJÄT PAIKAT: "+tyhjatPaikat);
		if (tyhjatPaikat > 0) {
		
		//ensimmäinen päivitys PreparedStatementCreatorilla ja KeyHolderilla
		lkm = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql1,
						new String[] { "id" });
				ps.setString(1, etunimi);
				ps.setString(2, sukunimi);
				ps.setString(3, sposti);
				ps.setString(4, puh);
				return ps;
			}
		}, idHolder);
				
		
		if (lkm == 1) { 	//jos ensimmäinen päivitys onnistui, tee toinen päivitys					
			final int kayttajaid = idHolder.getKey().intValue();
			
			
			lkm = jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql2);
					ps.setInt(1, kayttajaid);
					ps.setInt(2, tapahtumaid);
					return ps;
				}
			});
		}
			
		
	}		
		return lkm;
	}
	
	/*public List<Kayttaja> haeJarjestajat() {
		final String sql ="select t.jarjestaja_id, t.tapahtumaid, k.kayttajaid, k.etunimi, k.sukunimi, k.bio, k.sposti, k.puh from kayttaja k join tapahtuma t on k.kayttajaid = t.jarjestaja_id";		
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		
		List<Kayttaja> jarjestajat = jdbcTemplate.query(sql,mapper);
		return jarjestajat;
	}*/
	
}
