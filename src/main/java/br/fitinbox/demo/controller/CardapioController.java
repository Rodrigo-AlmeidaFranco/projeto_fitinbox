package br.fitinbox.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fitinbox.demo.model.Produto;
import br.fitinbox.demo.service.ProdutoService;

@Controller
public class CardapioController {
	ProdutoService service = new ProdutoService();
	
	@RequestMapping("/cardapio")
	public ModelAndView contato() throws SQLException{
		ArrayList<Produto> listaIniciante = service.listarIniciante();
		ArrayList<Produto> listaSalada = service.listarSalada();
		ArrayList<Produto> listaAperitivos = service.listarAperitivos();
		
		ModelAndView mv = new ModelAndView("cardapio");
		
		mv.addObject("listaSaladas",listaSalada);
		mv.addObject("listaAperitivo",listaAperitivos);
		mv.addObject("listaInici",listaIniciante);
		
		return mv;
	}
}
