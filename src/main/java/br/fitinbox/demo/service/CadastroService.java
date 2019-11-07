package br.fitinbox.demo.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import br.fitinbox.demo.DAO.CadastroDAO;
import br.fitinbox.demo.model.Cliente;

@Service
public class CadastroService {
	CadastroDAO dao = new CadastroDAO();
	
	public boolean Cadastrar(Cliente cliente) throws SQLException {
		return dao.cadstro(cliente);
	}
}
