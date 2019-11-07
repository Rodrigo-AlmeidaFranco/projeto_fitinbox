package br.fitinbox.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.fitinbox.demo.DAO.EnderecoDAO;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Endereco;

@Service
public class EnderecoService {
	EnderecoDAO dao = new EnderecoDAO();
	
	public ArrayList<Endereco> listarEndereco(Cliente cli) throws SQLException{
		return dao.listaEndereco(cli);
	}
	
	public void criarEndereco(Endereco end, Cliente cli) throws SQLException {
		dao.adiconarEndereco(end, cli);
	}
}
