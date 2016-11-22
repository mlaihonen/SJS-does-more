package fi.sjs.domore.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.dao.KayttajaDAO;

@Controller
@RequestMapping (value="/")
public class KayttajaController {
	
	@Inject
	@Qualifier("KayttajaDAOSpring")
	private KayttajaDAO dao;
	
	@RequestMapping("jarjestajat.json")
	public @ResponseBody List<Kayttaja> haeHenkilotJSON() {
		List<Kayttaja> jarjestajat = dao.haeJarjestajat();
		return jarjestajat;
	}
}		
