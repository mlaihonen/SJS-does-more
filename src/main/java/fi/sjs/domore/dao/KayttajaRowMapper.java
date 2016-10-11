package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.Kayttaja;

public class KayttajaRowMapper implements RowMapper<Kayttaja>{

	public Kayttaja mapRow(ResultSet rs, int rownum) throws SQLException {
		Kayttaja k = new Kayttaja();
		k.setId(rs.getInt("k_id"));
		k.setEtunimi(rs.getString("k_etunimi"));
		k.setSukunimi(rs.getString("k_sukunimi"));
		k.setKuvaus(rs.getString("k_kuvaus"));
		k.setSposti(rs.getString("k_sposti"));
		k.setPuh(rs.getString("k_puh"));
		
		return k;
	}
}
