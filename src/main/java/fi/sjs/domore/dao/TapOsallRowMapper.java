package fi.sjs.domore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sjs.domore.bean.TapahtumaOsallistuja;


public class TapOsallRowMapper implements RowMapper<TapahtumaOsallistuja>{
	public TapahtumaOsallistuja mapRow(ResultSet rs, int rowNum) throws SQLException {
		TapahtumaOsallistuja osall = new TapahtumaOsallistuja();
		osall.setKaytId(rs.getInt("k_id"));
		osall.setTapId(rs.getInt("t_id"));
				
		return osall;
	}

}
