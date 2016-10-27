package fi.sjs.domore.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;

@Repository
public class TapahtumaDAOSpringJdbcImpl implements TapahtumaDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Tapahtuma> haeKaikki() {
		String sql = "select t_id, t_nimi, t_kuvaus, t_pvm, t_aika, t_paikka from tapahtuma;";
		RowMapper<Tapahtuma> mapper = new TapahtumaRowMapper();
		List<Tapahtuma> tapahtumat = jdbcTemplate.query(sql, mapper);
		return tapahtumat;
		
	}
		
		public List<Kayttaja> haeOsallistujat(int t_id) {		
			String sql = "SELECT * FROM  kayttaja WHERE  k_id = (SELECT k_id FROM tapahtumaosallistuja WHERE t_id = ?); ";
			RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
			List<Kayttaja> osallistujat = jdbcTemplate.query(sql,mapper);

			return osallistujat;
		}
	}

