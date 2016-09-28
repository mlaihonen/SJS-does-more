package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.Tapahtuma;

public class TapahtumaRowMapper implements RowMapper<Tapahtuma>{

	//@Override
	public Tapahtuma mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tapahtuma t = new Tapahtuma();
		t.settId(rs.getInt("t_id"));
		t.settNimi(rs.getString("t_nimi"));
		t.settKuvaus(rs.getString("t_kuvaus"));
		//t.settPvm(rs.getDate("t_pvm"));
		//t.settAika(rs.getDate("t_aika"));
		t.settPaikka(rs.getString("t_paikka"));
		
		return t;
	}

}
