package br.fitinbox.demo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.fitinbox.demo.model.Cliente;

import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.service.LoginService;


@Controller
public class LoginController {
	private LoginService loginService = new LoginService();
	
	@GetMapping(value = { "/home" })
	public ModelAndView login(HttpServletRequest request,Login login) {
		HttpSession session = request.getSession();
		if(session.getAttribute("usuarioLogado") != null) {
			ModelAndView mv = new ModelAndView("pg-usuário");
			mv.addObject(new Login());
			return mv;
	}else {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject(new Login());
		return mv;
	}
	}
	
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(HttpServletRequest request,Login login) throws SQLException {
		if (loginService.fazerLogin(login)) {
			Cliente cli = loginService.sessao(login);
			request.getSession().setAttribute("usuarioLogado", cli);
			request.getSession().setAttribute("cliente", cli);
			return "redirect:perfil";
		} else {
			return "home";
		}
	}
}
