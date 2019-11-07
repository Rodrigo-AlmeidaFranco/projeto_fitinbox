package br.fitinbox.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.DAO.CarrinhoDAO;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Pedido;
import br.fitinbox.demo.model.Produto;

public class CarrinhoService {
	CarrinhoDAO dao = new CarrinhoDAO();
	
	public ArrayList<Produto> getCarrinho(Cliente cli) throws SQLException{
		return dao.getCarrinho(cli);
	}
}
