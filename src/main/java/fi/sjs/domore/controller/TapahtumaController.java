package fi.sjs.domore.controller;


import java.io.File;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@Qualifier("KayttajaDAOSpring")
	private KayttajaDAO dao;
	
	@Inject
	@Qualifier("TapahtumaDAOSpring")
	private TapahtumaDAO tDao;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String create() {
		
		return "etusivu";
	} 
	
	//Listaa kaikki tapahtumat
	@RequestMapping(value="tapahtumat", method=RequestMethod.GET)
	public String getList(Model model) {
		List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>(tDao.haeKaikki());
		for (int i = 1; i < tapahtumat.size(); i++) {
			List<Kayttaja> o = tDao.haeOsallistujat(tapahtumat.get(i).getId());
			tapahtumat.get(i).setOsallistujat(o);
		}
		model.addAttribute("tapahtumat", tapahtumat);
		return "tapahtumat";
	} 	
	
	//näytä yhden tapahtuman tiedot ja osallistumisformi
	@RequestMapping(value="tapahtumatiedot/{id}", method=RequestMethod.GET)
	public String viewTapahtuma(@PathVariable Integer id, Model model) { 
		Tapahtuma tapahtuma = tDao.etsi(id);
		model.addAttribute("tapahtuma", tapahtuma);
		
		if(!model.containsAttribute("kayttaja")){
			model.addAttribute("kayttaja", new KayttajaImpl());
		}
					
		return "tapahtumatiedot";
	}	

	
	//hae osallistumisformiin syötetyt tiedot
	@RequestMapping(value="tapahtumatiedot/{id}", method=RequestMethod.POST)
	public String createKayttaja(@ModelAttribute(value="kayttaja") @PathVariable Integer id, @Valid KayttajaImpl kayttaja, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.kayttaja", result);
			attr.addFlashAttribute("kayttaja", kayttaja);
			return "redirect:../tapahtumatiedot/"+id;
		} else {								
			return "redirect:../tapahtumatiedot/"+id+"/onnistui"; 
		}
	}
	
	//Tapahtumaan ilmoittautuminen onnistui
	@RequestMapping(value="tapahtumatiedot/{id}/onnistui", method=RequestMethod.GET)
	public String viewOnnistui(@PathVariable Integer id, Model model) { 
		Tapahtuma t = tDao.etsi(id);
		model.addAttribute("tapahtuma", t);
		model.addAttribute("onnistui", "onnistui");
		if(!model.containsAttribute("kayttaja")){
			model.addAttribute("kayttaja", new KayttajaImpl());
		}			
		return "tapahtumatiedot";
	}
	
	@RequestMapping(value="luotapahtuma", method=RequestMethod.GET)
	public String createTapahtuma(Model model) { 
		Tapahtuma tapahtuma = new TapahtumaImpl();
		Kayttaja kayttaja = new KayttajaImpl();
		//File file = new File("kuva");
		tapahtuma.setKayttaja(kayttaja);
		
		model.addAttribute("tapahtuma", tapahtuma);
		//model.addAttribute("file", file);
		
		return "luotapahtuma";
	}
	
	@RequestMapping(value="/yhteystiedot", method=RequestMethod.GET)
	public String viewYhteystiedot() { 
		
		return "yhteystiedot";
	}
	
	@RequestMapping(value="tallennatapahtuma", method=RequestMethod.POST)
	public String saveTapahtuma(@ModelAttribute(value="tapahtuma")  @Valid TapahtumaImpl tapahtuma, BindingResult result, Model model) { 
		
		if (result.hasErrors()) {
			model.addAttribute(tapahtuma);
			return "luotapahtuma"; 
		} else {						
			int jarjestajaId = tDao.lisaaUusi(tapahtuma);
			return "redirect:/uploadFile?jarjestaja="+jarjestajaId; 
		}		
		
	}	
		
}
