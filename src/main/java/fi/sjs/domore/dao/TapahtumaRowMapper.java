package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.KayttajaImpl;
import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.bean.TapahtumaImpl;

public class TapahtumaRowMapper implements RowMapper<Tapahtuma> {

	public Tapahtuma mapRow(ResultSet rs, int rowNum) throws SQLException {
		int nykyinenTid = 0;
		int edellinenTid = 0;		
		TapahtumaImpl t = new TapahtumaImpl();

		t.setId(rs.getInt("id"));
		t.setNimi(rs.getString("nimi"));
		t.setKuvaus(rs.getString("kuvaus"));
		t.setPvm(rs.getDate("pvm"));
		t.setAika(rs.getTime("aika"));
		t.setPaikka(rs.getString("paikka"));
		t.setMaxOsallistujaLkm(rs.getInt("maxosallistujalkm"));
		edellinenTid = nykyinenTid;
							
		int jId = rs.getInt("jarjestaja_id");
		int kId = rs.getInt("kid");
		
		if (jId == kId) {
			KayttajaImpl k = new KayttajaImpl();
			k.setId(kId);
			k.setEtunimi(rs.getString("etunimi"));
			k.setSukunimi(rs.getString("sukunimi"));
			k.setKuvaus(rs.getString("kkuvaus"));
			k.setPuh(rs.getString("puh"));
			k.setSposti(rs.getString("sposti"));
			t.setKayttaja(k);
		}
		
		return t;
	}
}
