package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Produto;


public class CompraDAO {
	CarrinhoDAO carrinho = new CarrinhoDAO();
	public void comprar(Cliente cli,ArrayList<Produto> produto) throws SQLException {
		String sqlInsert = "INSERT INTO tb_pedido VALUES (?,?,?,?,?,?,?);";
		
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);
		
		for(int x =0;x < produto.size(); x++) {
			stm.setInt(1, 0);
			stm.setInt(2, cli.getId_cliente());
			stm.setInt(3, 1);
			stm.setInt(4, produto.get(x).getId_produto());
			stm.setInt(5, 1);
			stm.setInt(6, produto.get(x).getId_volume());
			stm.setBoolean(7,  false);
			
			stm.execute();
		}
		
		carrinho.limparCarrinho(cli);
		
		
	}
}
