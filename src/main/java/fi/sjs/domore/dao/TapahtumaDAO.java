package fi.sjs.domore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;

import fi.sjs.domore.bean.Tapahtuma;

public class TapahtumaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Tapahtuma> haeKaikki() {
		String sql = "select t_id, t_nimi, t_kuvaus, t_pvm, t_aika, t_paikka from tapahtumat;";
		//List<Tapahtuma> tapahtumat = jdbcTemplate.query(sql, mapper);
		//return tapahtumat;
		return null; //poista tämä
	}


}
