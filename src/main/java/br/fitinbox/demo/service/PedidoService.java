package br.fitinbox.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.DAO.PedidoDAO;
import br.fitinbox.demo.model.Pedido;

public class PedidoService {
	PedidoDAO dao = new PedidoDAO();
	
	public ArrayList<Pedido> historicoPedido(Integer id) throws SQLException{
		return dao.listarPedido(id);
	}
}
