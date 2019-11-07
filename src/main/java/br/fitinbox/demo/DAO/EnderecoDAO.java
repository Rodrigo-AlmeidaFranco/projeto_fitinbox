package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Cliente;
import br.fitinbox.demo.model.Endereco;

public class EnderecoDAO {
	
	public ArrayList<Endereco> listaEndereco(Cliente cli) throws SQLException{
		String sqlSelect = "SELECT * FROM tb_endereco Where id_cliente = ?";
		Endereco endereco ;
		ArrayList<Endereco> lista = new ArrayList<Endereco>();
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setInt(1, cli.getId_cliente());
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			endereco = new Endereco();
			endereco.setId_endereco(rs.getInt(1));
			endereco.setId_cliente(rs.getInt(2));
			endereco.setNome(rs.getString(3));
			endereco.setLogradouro(rs.getString(4));
			endereco.setNumero(rs.getString(5));
			endereco.setCidade(rs.getString(6));
			endereco.setEstado(rs.getString(7));
			
			lista.add(endereco);
		}
		return lista;
	}
	
	public void adiconarEndereco(Endereco end,Cliente cli) throws SQLException {
		String sqlInsert = ("INSERT INTO tb_endereco VALUES (?,?,?,?,?,?,?)");
		
		Connection conn = ConnectionFactory.obterConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);
		
		stm.setInt(1, 0);
		stm.setInt(2, cli.getId_cliente());
		stm.setString(3, end.getNome());
		stm.setString(4, end.getLogradouro());
		stm.setString(5, end.getNumero());
		stm.setString(6, end.getCidade());
		stm.setString(7, end.getEstado());
		
		stm.execute();
		
	}
}
