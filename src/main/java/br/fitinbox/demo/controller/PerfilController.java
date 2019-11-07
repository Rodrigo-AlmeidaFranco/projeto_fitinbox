package br.fitinbox.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Endereco;
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.model.Pedido;
import br.fitinbox.demo.service.EnderecoService;
import br.fitinbox.demo.service.PedidoService;

@Controller
public class PerfilController {
	EnderecoService service = new EnderecoService();
	PedidoService pedidoService = new PedidoService();
	
	@RequestMapping("/perfil")
	public ModelAndView perfil(HttpServletRequest request,Login login) throws SQLException{
		HttpSession session = request.getSession();
		if(session.getAttribute("cliente") !=null) {
			Cliente perfil = new Cliente();
			perfil = (Cliente) session.getAttribute("cliente");
			ArrayList<Endereco> lista = service.listarEndereco(perfil);
			ArrayList<Pedido> ped = pedidoService.historicoPedido(perfil.getId_cliente());
			ModelAndView mv = new ModelAndView("pg-usuário");
			mv.addObject("cliente", perfil);
			mv.addObject("endereco", lista);
			mv.addObject("pedido", ped);
			return mv;
		}else {
			Cliente perfil = (Cliente) session.getAttribute("usuario");
			ModelAndView mv = new ModelAndView("pg-usuário");
			mv.addObject("cliente", perfil);
			return mv;
		}
		
		
	}
}
