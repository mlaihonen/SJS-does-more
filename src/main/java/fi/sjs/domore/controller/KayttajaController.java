package fi.sjs.domore.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import fi.sjs.domore.bean.KayttajaImpl;
import fi.sjs.domore.dao.KayttajaDAO;

@Controller
@RequestMapping (value="/asd")
public class KayttajaController {
	/*
	@Inject
	private KayttajaDAO dao;
	
		//Osallistu-formin tietojen vastaanotto
		@RequestMapping(value="/osallistu/{id}", method=RequestMethod.POST)
		public String create( @PathVariable Integer id, @ModelAttribute(value="kayttaja") @Valid KayttajaImpl kayttaja, BindingResult result) {
			if (result.hasErrors()) {
				return "/tapahtumat"; //t�m� nyt ohjaa vain lataamaan tapahtumat sivulle mutta url on edelleen sama, joten ei hae tapahtumia eik� n�yt� erroreita
			} else {						// jos laittaa return "redirect:.././"; niin se hakee tapahtumat sivun uudelleen mutta ei n�yt� erroreita
				dao.lisaaUusi(kayttaja, id);	// en keksi miten voidaan n�ytt�� java errorit ilman omaa jspt� osallistumiselle. Tai sitten tehd��n jsp joka n�ytet��n vain jos tulee erroreita...
				return "redirect:.././onnistui"; //postista pit�� ohjata eteenp�in redirectill�. Ilman .././ se yritt�isi ohjata osallistu/id/ alla sijaitsevaan onnistui
			}
		}	
		
		@RequestMapping(value="/onnistui", method=RequestMethod.GET)
		public String viewOnnistui() { //ilman t�t� ei voida n�ytt�� onnistui sivua
			
			return "onnistui";
		}	*/
}		

//