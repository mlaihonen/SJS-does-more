package fi.sjs.domore.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.dao.KayttajaDAO;

@Controller
@RequestMapping (value="/")
public class KayttajaController {
	@Inject
	private KayttajaDAO dao;
	
		//FORMIN NÄYTTÄMINEN
		@RequestMapping(value="/", method=RequestMethod.POST)
		public String getCreateForm(Model model) {
			Kayttaja kayttaja = new Kayttaja();
			model.addAttribute("kayttaja", kayttaja);
			return "tapahtumat"; 
		}
		
//		//FORMIN TIETOJEN VASTAANOTTO
//		@RequestMapping(value="/", method=RequestMethod.GET)
//		public String create( @ModelAttribute(value="kayttaja") Kayttaja kayttaja) {
//			dao.lisaaUusi(kayttaja);
//			return "redirect:/onnistui/" + kayttaja.getId();
//		}
}
