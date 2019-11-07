package br.fitinbox.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Endereco;
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.service.EnderecoService;

@Controller
public class DadosController {
	EnderecoService service = new EnderecoService();
	
	@RequestMapping("/dados")
	public ModelAndView dados(HttpServletRequest request,Login login) throws SQLException{
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("pg-dados-conta");
		if(session.getAttribute("cliente") !=null) {
			Cliente perfil = new Cliente();
			perfil = (Cliente) session.getAttribute("cliente");
			ArrayList<Endereco> lista = service.listarEndereco(perfil);
			mv.addObject("cliente", perfil);
			mv.addObject("endereco", lista);
			mv.addObject("end", new Endereco());
			return mv;
		}
		return mv;
	}
	
	@PostMapping("/cadastrarEnd")
	public String fazerLogin(HttpServletRequest request,Endereco end) throws SQLException {
		HttpSession session = request.getSession();
		Cliente cli = (Cliente) session.getAttribute("cliente");
		service.criarEndereco(end, cli);
			return "redirect:perfil";
		
	}
}
