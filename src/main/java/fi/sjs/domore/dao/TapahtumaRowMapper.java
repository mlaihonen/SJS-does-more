package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.bean.TapahtumaImpl;

public class TapahtumaRowMapper implements RowMapper<Tapahtuma>{

	public Tapahtuma mapRow(ResultSet rs, int rowNum) throws SQLException {
		TapahtumaImpl t = new TapahtumaImpl();
		t.setId(rs.getInt("t_id"));
		t.setNimi(rs.getString("t_nimi"));
		t.setKuvaus(rs.getString("t_kuvaus"));
		t.setPvm(rs.getDate("t_pvm"));
		t.setAika(rs.getTime("t_aika"));
		t.setPaikka(rs.getString("t_paikka"));
		t.setMaxOsallistujaLkm(rs.getInt("t_maxosallistujalkm"));
		return t;
	}

}
