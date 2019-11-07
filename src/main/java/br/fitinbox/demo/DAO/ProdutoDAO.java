package br.fitinbox.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fitinbox.demo.connection.ConnectionFactory;
import br.fitinbox.demo.model.Produto;


public class ProdutoDAO {
	
	public ArrayList<Produto> listarProdutos() {
		Produto produto;
		ArrayList<Produto> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tb_produto";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					produto = new Produto();
					produto.setId_produto(rs.getInt(1));
					produto.setDescricao(rs.getString(2));
					produto.setNome(rs.getString(3));
					produto.setPreco(rs.getString(4));
					produto.setId_tipo(rs.getInt(5));
					produto.setId_volume(rs.getInt(6));
					lista.add(produto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public ArrayList<Produto> listaSaladas() throws SQLException{
		Produto produto;
		ArrayList<Produto> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from tb_produto WHERE id_tipo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); 
			ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					produto = new Produto();
					produto.setId_produto(rs.getInt(1));
					produto.setDescricao(rs.getString(2));
					produto.setNome(rs.getString(3));
					produto.setPreco(rs.getString(4));
					produto.setId_tipo(rs.getInt(5));
					produto.setId_volume(rs.getInt(6));
					lista.add(produto);
				}
		
		
		return lista;
	}
	
	
	public ArrayList<Produto> listaIniciantes() throws SQLException{
		Produto produto;
		ArrayList<Produto> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from tb_produto WHERE id_tipo = 2";
		// usando o try with resources do Java 7, que fecha o que abriu
		Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); 
			ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					produto = new Produto();
					produto.setId_produto(rs.getInt(1));
					produto.setDescricao(rs.getString(2));
					produto.setNome(rs.getString(3));
					produto.setPreco(rs.getString(4));
					produto.setId_tipo(rs.getInt(5));
					produto.setId_volume(rs.getInt(6));
					lista.add(produto);
				}
		
		
		return lista;
	}
	
	public ArrayList<Produto> listaAperitivos() throws SQLException{
		Produto produto;
		ArrayList<Produto> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from tb_produto WHERE id_tipo = 3";
		// usando o try with resources do Java 7, que fecha o que abriu
		Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); 
			ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					produto = new Produto();
					produto.setId_produto(rs.getInt(1));
					produto.setDescricao(rs.getString(2));
					produto.setNome(rs.getString(3));
					produto.setPreco(rs.getString(4));
					produto.setId_tipo(rs.getInt(5));
					produto.setId_volume(rs.getInt(6));
					lista.add(produto);
				}
		
		
		return lista;
	}
}
