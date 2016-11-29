package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.KayttajaImpl;

public class KayttajaRowMapper implements RowMapper<Kayttaja>{

	public Kayttaja mapRow(ResultSet rs, int rownum) throws SQLException {
		KayttajaImpl k = new KayttajaImpl();
		k.setId(rs.getInt("kid"));
		k.setEtunimi(rs.getString("etunimi"));
		k.setSukunimi(rs.getString("sukunimi"));
		k.setKuvaus(rs.getString("kkuvaus"));
		k.setPuh(rs.getString("puh"));
		k.setSposti(rs.getString("sposti"));
		return k;
		
	}
}
