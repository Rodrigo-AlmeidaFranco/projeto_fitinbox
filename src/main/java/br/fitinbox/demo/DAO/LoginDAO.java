package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;


public class LoginDAO {
public Boolean fazerLogin(Login login) throws SQLException{
		
		String sqlSelect = "SELECT * FROM tb_login WHERE login = ? and senha = ?";
		// pega a conexÃ£o em um try normal para que ela nÃ£o seja fechada
		try {
			Connection conn = ConnectionFactory.obterConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, login.getLogin());
				stm.setString(2, login.getSenha());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						System.out.println("ok ok ok ");
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}


public Cliente sessaoUsuario(Login login) throws SQLException {
	String sqlSelect = "SELECT * FROM tb_login WHERE login = ? and senha = ?";
	ClienteDAO dao = new ClienteDAO();
	Cliente cliente = new Cliente();
	Connection conn = ConnectionFactory.obterConexao();
	PreparedStatement stm = conn.prepareStatement(sqlSelect);
	stm.setString(1, login.getLogin());
	stm.setString(2, login.getSenha());
	
	ResultSet rs = stm.executeQuery();
	
	if (rs.next()) {
		login =  new Login();
		login.setId_login(rs.getInt(1));
		cliente = dao.getCliente(login.getId_login());
		return cliente;
	}else {
		return null;
	}
}


}
