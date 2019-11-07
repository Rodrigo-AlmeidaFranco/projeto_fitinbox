package br.fitinbox.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;

@Controller
public class MainController {
	
	@RequestMapping("/contato")
	public ModelAndView contato(){
		ModelAndView mv = new ModelAndView("contato");
		return mv;
	}
	
	
	
	

}
