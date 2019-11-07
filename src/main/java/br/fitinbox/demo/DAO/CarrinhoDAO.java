package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Carrinho;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Pedido;
import br.fitinbox.demo.model.Produto;

public class CarrinhoDAO {
	
	public  ArrayList<Produto>  getCarrinho(Cliente cli) throws SQLException {
		String sqlSelect = "SELECT * FROM tb_carrinho WHERE id_cliente = ? ";
		Produto prod;
		Carrinho carrinho;
		ArrayList<Produto> lista = new ArrayList<>();
		
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setInt(1, cli.getId_cliente());
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			carrinho = new Carrinho();
			carrinho.setId_produto(rs.getInt(1));
			carrinho.setId_cliente(rs.getInt(2));
			
			lista.add(listarProdutos(carrinho));
		}
		return lista;
	}
	
	
	public Produto listarProdutos(Carrinho car) throws SQLException {
		Produto prod = null;
		String sqlSelect = "SELECT * FROM tb_produto WHERE id = ?";
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setInt(1, car.getId_produto());
			ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					prod = new Produto();
					prod.setId_produto(rs.getInt(1));
					prod.setNome(rs.getString(3));
					prod.setPreco(rs.getString(4));
					prod.setId_tipo(rs.getInt(5));
					prod.setId_volume(rs.getInt(6));
				}
			
		
		return prod;
	}
	
	public void limparCarrinho(Cliente cli) throws SQLException {
		String sqlDelte = "DELETE  FROM tb_carrinho WHERE id_cliente = 1";
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelte);
		stm.setInt(1, cli.getId_cliente());
		
		stm.execute();
	}
	
}
