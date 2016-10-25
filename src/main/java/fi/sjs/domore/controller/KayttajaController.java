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
@RequestMapping (value="/")
public class KayttajaController {
	
	@Inject
	private KayttajaDAO dao;
	
		//Osallistu-formin tietojen vastaanotto
		@RequestMapping(value="/osallistu{id}", method=RequestMethod.POST)
		public String create( @PathVariable Integer id, @ModelAttribute(value="kayttaja") @Valid KayttajaImpl kayttaja, BindingResult result) {
			if (result.hasErrors()) {
				return "redirect:/";
			} else {
				dao.lisaaUusi(kayttaja, id);
				return "onnistui";
			}
		}	
}		

