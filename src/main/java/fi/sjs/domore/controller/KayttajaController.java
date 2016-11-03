package fi.sjs.domore.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.sjs.domore.bean.KayttajaImpl;
import fi.sjs.domore.dao.KayttajaDAO;

//@Controller
//@RequestMapping (value="/..")
public class KayttajaController {
	
	//tätä ei ainakaan vielä tarvita, vaan kaikki on tapahtumacontrollerissa

	/*@Inject
	@Qualifier("KayttajaDAOSpring")
	private KayttajaDAO dao;*/
	
		
}		
