package fi.sjs.domore.controller;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.sjs.domore.dao.UploadDAO;

@Controller
@RequestMapping(value="/")
public class UploadController<MultipartConfigFactory> {
	
	@Inject
	@Qualifier("UploadDao")
	private UploadDAO dao;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String Upload(@RequestParam("jarjestaja") int jarjestajaId, Model model){
		
		model.addAttribute("jarjestaja");
		
		return "UploadFile";
	}
	 
	 
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	 public String UploadFile(@RequestParam("file") MultipartFile file, @RequestParam("jarjestaja") int jarjestajaId){
		
		System.out.println("File: "+file.toString());
		
		 if (!file.isEmpty()) {
			 dao.saveImage(file, jarjestajaId);
			 return "redirect:/onnistui";
		 } else {
			 
			 return "UploadFile";
		 }
	            
		 
	 }
	
	
	 
	
	 
	

	    
	 
}
