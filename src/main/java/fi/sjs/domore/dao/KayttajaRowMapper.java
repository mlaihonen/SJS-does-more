package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.KayttajaImpl;

public class KayttajaRowMapper implements RowMapper<Kayttaja>{

	public Kayttaja mapRow(ResultSet rs, int rownum) throws SQLException {
		KayttajaImpl k = new KayttajaImpl();
		k.setId(rs.getInt("k_id"));
		k.setEtunimi(rs.getString("k_etunimi"));
		k.setSukunimi(rs.getString("k_sukunimi"));
		k.setKuvaus(rs.getString("k_kuvaus"));
		k.setSposti(rs.getString("k_sposti"));
		k.setPuh(rs.getString("k_puh"));
		
		return k;
		
	}
}
