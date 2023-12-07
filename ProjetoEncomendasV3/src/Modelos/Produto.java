package Modelos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controle.Conexao;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Produto {

	private int idProduto;
	private String nome;
	private String categoria;
	private String referencia;
	private int quantidade;
	private Double preco;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean inserirProdutoNoBanco(Connection conexao) {
		String query = "INSERT INTO produtos (NOME, CATEGORIA, REFERENCIA, QUANTIDADE, PRECO) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
			preparedStatement.setString(1, this.getNome());
			preparedStatement.setString(2, this.getCategoria());
			preparedStatement.setString(3, this.getReferencia());
			preparedStatement.setInt(4, this.getQuantidade());
			preparedStatement.setDouble(5, this.getPreco());
			preparedStatement.executeUpdate();

			return true; // Produto inserido com sucesso
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Falha ao inserir o produto
		}

		
		
		
	}
	
	public List<Produto> buscarProdutosDoBanco() {
	    List<Produto> produtos = new ArrayList<>();

	    try (Connection conexao = Conexao.getConnection()) {
	        String query = "SELECT NOME, CATEGORIA, REFERENCIA, QUANTIDADE, PRECO FROM produtos";

	        try (PreparedStatement preparedStatement = conexao.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                Produto produto = new Produto();
	                produto.setNome(resultSet.getString("NOME"));
	                produto.setCategoria(resultSet.getString("CATEGORIA"));
	                produto.setReferencia(resultSet.getString("REFERENCIA"));
	                produto.setQuantidade(resultSet.getInt("QUANTIDADE"));
	                produto.setPreco(resultSet.getDouble("PRECO"));
	                
	                produtos.add(produto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produtos;
	}

}
