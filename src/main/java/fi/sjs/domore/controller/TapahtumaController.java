package fi.sjs.domore.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.sjs.domore.bean.Kayttaja;
import fi.sjs.domore.bean.Tapahtuma;
import fi.sjs.domore.dao.TapahtumaDAO;


@Controller
@RequestMapping (value="/")
public class TapahtumaController {
	
	@Inject
	private TapahtumaDAO dao;
	
	//Listaa kaikki tapahtumat
		@RequestMapping(value="/", method=RequestMethod.GET)
		public String getList(Model model) {
			List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>(dao.haeKaikki());
			
			//Muokkaa pvmn ja ajan oikeaan muotoon
			/*for(int i=0;i<tapahtumat.size();i++){
				Date pvm = tapahtumat.get(i).getPvm();
				SimpleDateFormat dfPvm = new SimpleDateFormat("dd.MM.yyyy");
				String strPvm = dfPvm.format(pvm);
				try {
					pvm = dfPvm.parse(strPvm);
					System.out.println(pvm);
				} catch (ParseException e) {
					System.out.println("getPvm meni vikaan.");
					e.printStackTrace();
				}
				
				tapahtumat.get(i).setPvm(pvm);
				
				Date aika = tapahtumat.get(i).getAika();
				SimpleDateFormat dfAika = new SimpleDateFormat("HH:mm");
				String strAika = dfAika.format(aika);
				try {
					aika = dfAika.parse(strAika);
					System.out.println(aika);
				} catch (ParseException e) {
					System.out.println("getAika meni vikaan.");
					e.printStackTrace();
				}
				System.out.println(aika);
				
				tapahtumat.get(i).setAika(aika);
			}*/
			
			model.addAttribute("tapahtumat", tapahtumat);
			Kayttaja kayttaja = new Kayttaja();
			model.addAttribute("kayttaja", kayttaja);
			return "tapahtumat";
		}
		
}
