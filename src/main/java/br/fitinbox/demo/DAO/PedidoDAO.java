package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Pedido;


public class PedidoDAO {
	
	public ArrayList<Pedido> listarPedido(Integer id) throws SQLException {
		Pedido ped;
		ArrayList<Pedido> lista = new ArrayList<>();
		String sqlSelect = " SELECT prod.nome, prod.preco,ende.nome\r\n" + 
				"				FROM tb_pedido AS ped\r\n" + 
				"				JOIN tb_produto AS prod ON prod.id = ped.id_produto INNER JOIN tb_endereco AS ende on ende.id = ped.id_endereco WHERE ped.id_cliente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					ped = new Pedido();
					ped.setNome(rs.getString(1));
					ped.setPreco(rs.getString(2));
					ped.setEndereco(rs.getString(3));
					lista.add(ped);
				}
			
		
		return lista;
	}
}
