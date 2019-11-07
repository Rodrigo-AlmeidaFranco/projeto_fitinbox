package br.fitinbox.demo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.service.CadastroService;

@Controller
public class CadastroController {
	CadastroService service = new CadastroService();
	
	@GetMapping("/cadastro")
	public ModelAndView contato(HttpServletRequest request,Cliente cliente){
		HttpSession session = request.getSession();
		if(session.getAttribute("cliente") != null) {
			ModelAndView mv = new ModelAndView("pg-cadastro");
			mv.addObject(new Cliente());
			return mv;
	}else {
		ModelAndView mv = new ModelAndView("pg-cadastro");
		mv.addObject(new Cliente());
		return mv;
	}
	}
	
	@PostMapping("/cadastrar")
	public String fazerLogin(HttpServletRequest request,Cliente cliente) throws SQLException {
		if (service.Cadastrar(cliente)) {
			request.getSession().setAttribute("cliente", cliente);
			return "redirect:perfil";
		} else {
			return "perfil";
		}
	}
}
