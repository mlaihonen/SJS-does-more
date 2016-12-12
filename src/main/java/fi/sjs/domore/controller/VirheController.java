package fi.sjs.domore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class VirheController {

	    @ExceptionHandler(Exception.class)
	    public String handleException(Throwable t) {
	        return "virhe";
	    }
}
