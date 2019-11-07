package br.fitinbox.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.DAO.CompraDAO;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Produto;

public class CompraService {
	CompraDAO dao = new CompraDAO();
	
	public void comprar(Cliente cli, ArrayList<Produto> produto) throws SQLException {
		dao.comprar(cli, produto);
	}
}
