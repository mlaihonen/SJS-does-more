package fi.sjs.domore.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.KayttajaImpl;
import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.bean.TapahtumaImpl;
import fi.sjs.domore.dao.TapahtumaDAO;


@Controller
@RequestMapping (value="/")
public class TapahtumaController {
	
	@Inject
	@Qualifier("TapahtumaDAOHibernate")
	private TapahtumaDAO hibernateDAO;

	/*@Inject
	private TapahtumaDAO dao;*/	
	
	//Listaa kaikki tapahtumat
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getList(Model model) {
		List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>(hibernateDAO.haeKaikki());
		model.addAttribute("tapahtumat", tapahtumat);
		return "tapahtumat";
	} 
	
	@RequestMapping(value="tapahtumatiedot/{id}", method=RequestMethod.GET)
	public String viewTapahtuma(@PathVariable Integer id, Model model) { 
		Tapahtuma tapahtuma = hibernateDAO.etsi(id);
		model.addAttribute("tapahtuma", tapahtuma);
		Kayttaja kayttaja = new KayttajaImpl();
		model.addAttribute("kayttaja", kayttaja);
		return "tapahtumatiedot";
	}	
	
	@RequestMapping(value="luotapahtuma", method=RequestMethod.GET)
	public String createTapahtuma(Model model) { 
		Tapahtuma tapahtuma = new TapahtumaImpl();
		model.addAttribute("tapahtuma", tapahtuma);
		
		return "luotapahtuma";
	}	
		
}
