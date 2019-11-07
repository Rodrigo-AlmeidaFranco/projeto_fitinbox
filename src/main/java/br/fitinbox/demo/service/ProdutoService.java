package br.fitinbox.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.DAO.ProdutoDAO;
import br.fitinbox.demo.model.Produto;

public class ProdutoService {
	ProdutoDAO dao = new ProdutoDAO();
	
	public ArrayList<Produto> listaProduto(){
		return dao.listarProdutos();
	}
	
	public ArrayList<Produto> listarSalada() throws SQLException{
		return dao.listaSaladas();
	}
	
	public ArrayList<Produto> listarIniciante() throws SQLException{
		return dao.listaIniciantes();
	}
	
	public ArrayList<Produto> listarAperitivos() throws SQLException{
		return dao.listaAperitivos();
	}
}
