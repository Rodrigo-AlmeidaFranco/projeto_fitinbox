package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;

public class CadastroDAO {
	
	public boolean cadstro(Cliente cliente) throws SQLException {
		
		String sqlInsertLogin = "INSERT INTO tb_login VALUES (?,?,?)";
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsertLogin);
		stm.setInt(1, 0);
		stm.setString(2, cliente.getLogin());
		stm.setString(3, cliente.getSenha());
		
		 stm.execute();
		    String sqlSelect = "SELECT * FROM tb_login Where login = ? and senha = ?";
		    
				Connection conect = ConnectionFactory.obterConexao();
				// usando o try with resources do Java 7, que fecha o que abriu
				stm = conn.prepareStatement(sqlSelect);
					stm.setString(1, cliente.getLogin());
					stm.setString(2, cliente.getSenha());
					ResultSet rs = stm.executeQuery();
						if (rs.next()) {
							cliente.setId_login(rs.getInt(1));
							System.out.println("ok ok ok ");
							return true;
						}
			String sqlInsertCliente = "INSERT INTO tb_cliente VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlInsertCliente);
			
			stmt.setInt(1, 0);
			stmt.setString(2, cliente.getCPF());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getTelefone());
			stmt.setInt(6, cliente.getId_login());
			stmt.execute();
			return true;
					
	}
		    
}
