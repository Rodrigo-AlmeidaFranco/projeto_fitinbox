package br.fitinbox.demo.service;

import java.sql.SQLException;

import br.fitinbox.demo.DAO.LoginDAO;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Login;

public class LoginService {
	LoginDAO dao = new LoginDAO();
	
	public Boolean fazerLogin(Login login) throws SQLException {
		return dao.fazerLogin(login);
	}
	
	public Cliente sessao(Login log) throws SQLException {
		return dao.sessaoUsuario(log);
	}
}
