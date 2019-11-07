package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Login;
import br.fitinbox.demo.model.Cliente;

public class ClienteDAO {
	
	public Cliente getCliente(Integer id) throws SQLException {
		Cliente cli = new Cliente();
		String sqlSelect = "SELECT * FROM tb_cliente WHERE login_id = ?";
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		
		if (rs.next()) {
			cli.setId_cliente(rs.getInt(1));
			cli.setCPF(rs.getString(2));
			cli.setEmail(rs.getString(3));
			cli.setNome(rs.getString(4));
			cli.setTelefone(rs.getString(5));
			return cli;
		}
		
		return cli;
	}
	
	public void updateCliente(Cliente cli) throws SQLException {
		String sqlUpdate= " UPDATE tb_cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);
		stm.setString(1, cli.getNome());
		stm.setString(2, cli.getEmail());
		stm.setString(3, cli.getTelefone());
		stm.setInt(4, cli.getId_cliente());
		stm.executeQuery();
	}
	
}
