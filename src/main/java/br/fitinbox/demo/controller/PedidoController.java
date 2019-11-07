package br.fitinbox.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.model.Pedido;
import br.fitinbox.demo.service.PedidoService;

@Controller
public class PedidoController {
	PedidoService service = new PedidoService();
	
	@RequestMapping("/pedidos")
	public ModelAndView pedidos(HttpServletRequest request,Login login) throws SQLException{
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("pg-historico-pedidos");
		if(session.getAttribute("cliente") !=null) {
			Cliente perfil = new Cliente();
			perfil = (Cliente) session.getAttribute("cliente");
			ArrayList<Pedido> ped = service.historicoPedido(perfil.getId_cliente());
			mv.addObject("cliente", perfil);
			mv.addObject("pedido", ped);
		}
		return mv;
	}
}
