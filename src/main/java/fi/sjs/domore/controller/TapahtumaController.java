package fi.sjs.domore.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.KayttajaImpl;
import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.bean.TapahtumaImpl;
import fi.sjs.domore.dao.KayttajaDAO;
import fi.sjs.domore.dao.TapahtumaDAO;


@Controller
@RequestMapping (value="/")
public class TapahtumaController {
	
	@Inject
	@Qualifier("TapahtumaDAOHibernate")
	private TapahtumaDAO hibernateDAO;
	
	@Inject
	@Qualifier("KayttajaDAOSpring")
	private KayttajaDAO dao;

	/*@Inject
	private TapahtumaDAO dao;*/	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String create(Model model) {
		
		return "etusivu";
	} 
	
	//Listaa kaikki tapahtumat
	@RequestMapping(value="tapahtumat", method=RequestMethod.GET)
	public String getList(Model model) {
		List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>(hibernateDAO.haeKaikki());
		model.addAttribute("tapahtumat", tapahtumat);
		return "tapahtumat";
	} 	
	
	//näytä yhden tapahtuman tiedot ja osallistumisformi
	@RequestMapping(value="tapahtumatiedot/{id}", method=RequestMethod.GET)
	public String viewTapahtuma(@PathVariable Integer id, Model model) { 
		Tapahtuma tapahtuma = hibernateDAO.etsi(id);
		model.addAttribute("tapahtuma", tapahtuma);
		
		if(!model.containsAttribute("kayttaja")){
			model.addAttribute("kayttaja", new KayttajaImpl());
		}
		
		//Kayttaja kayt = (Kayttaja) model.addAttribute("kayttaja", kayttaja);
		/*if(kayt == null){
			Kayttaja tyhjaKayttaja = new KayttajaImpl();
			model.addAttribute("kayttaja", tyhjaKayttaja);
		}*/
				
		//model.addAttribute("tapahtuma", tapahtuma);
		//Kayttaja tyhjaKayttaja = new KayttajaImpl();
		//model.addAttribute("kayttaja", tyhjaKayttaja);
		
		//model.addAttribute("kayttaja", kayttaja);
			
		return "tapahtumatiedot";
	}	

	
	//hae osallistumisformiin syötetyt tiedot
	@RequestMapping(value="tapahtumatiedot/{id}", method=RequestMethod.POST)
	public String createKayttaja(@ModelAttribute(value="kayttaja") @PathVariable Integer id, @Valid KayttajaImpl kayttaja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(kayttaja);
			return "tapahtumatiedot"; //virhetekstit eivät vielä näy...
		} else {						
			dao.lisaaUusi(kayttaja, id);	
			return "redirect:.././onnistui"; 
		}
	}
	
	@RequestMapping(value="/onnistui", method=RequestMethod.GET)
	public String viewOnnistui() { //ilman tätä ei voida näyttää onnistui sivua
		
		return "onnistui";
	}
	
	@RequestMapping(value="luotapahtuma", method=RequestMethod.GET)
	public String createTapahtuma(Model model) { 
		Tapahtuma tapahtuma = new TapahtumaImpl();
		model.addAttribute("tapahtuma", tapahtuma);
		
		return "luotapahtuma";
	}	
	
	@RequestMapping(value="tallennatapahtuma", method=RequestMethod.POST)
	public String saveTapahtuma(@ModelAttribute(value="tapahtuma")  @Valid TapahtumaImpl tapahtuma, BindingResult result, Model model) { 
		
		if (result.hasErrors()) {
			model.addAttribute(tapahtuma);
			return "luotapahtuma"; 
		} else {						
			hibernateDAO.lisaaUusi(tapahtuma);	
			return "redirect:.././onnistui"; 
		}
		
		
	}	
		
}
