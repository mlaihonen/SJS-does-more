package fi.sjs.domore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.dao.TapahtumaDAO;


@Controller
@RequestMapping (value="/")
public class TapahtumaController {
	
	@Inject
	private TapahtumaDAO dao;
	
	public TapahtumaDAO getDao() {
		return dao;
	}

	public void setDao(TapahtumaDAO dao) {
		this.dao = dao;
	}
	
	//Listaa kaikki tapahtumat
		@RequestMapping(value="/", method=RequestMethod.GET)
		public String getList(Model model) {
			List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>(dao.haeKaikki());
			model.addAttribute("tapahtumat", tapahtumat);
			return "tapahtumat";
		}
}
