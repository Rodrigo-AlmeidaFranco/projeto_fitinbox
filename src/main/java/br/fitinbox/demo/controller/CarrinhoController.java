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
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.model.Pedido;
import br.fitinbox.demo.model.Produto;
import br.fitinbox.demo.service.CarrinhoService;
import br.fitinbox.demo.service.CompraService;

@Controller
public class CarrinhoController {
	CarrinhoService service = new CarrinhoService();
	CompraService compraService = new CompraService();
	
	@RequestMapping("/carrinho")
	public ModelAndView carrinho(HttpServletRequest request,Cliente cliente) throws SQLException{
		HttpSession session = request.getSession();
		cliente = (Cliente) session.getAttribute("cliente"); 
		ModelAndView mv = new ModelAndView("pg-carrinho");
		ArrayList<Produto> lista = service.getCarrinho(cliente);
		mv.addObject("carrinho",lista);
		return mv;
	}
	
	@PostMapping("/comprar")
	public String comprar(HttpServletRequest request,Cliente cliente) throws SQLException{
		HttpSession session = request.getSession();
		cliente = (Cliente) session.getAttribute("cliente"); 
		ArrayList<Produto> lista = service.getCarrinho(cliente);
		compraService.comprar(cliente, lista);
		return "perfil";
	}
}
