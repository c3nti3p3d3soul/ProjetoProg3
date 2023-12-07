package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Controle.Conexao;

public class Usuario {

	private int idUsuario;
	private String Nome;
	private String CPF;
	private String senha;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		CPF = CPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	Contato CT = new Contato();
	public boolean inserirUsuario(Connection conexao) {
		String query = "INSERT INTO Usuarios (NOME, CPF, SENHA) VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
			preparedStatement.setString(1, this.getNome());
			preparedStatement.setString(2, this.getCPF());
			preparedStatement.setString(3, this.getSenha());
			preparedStatement.executeUpdate();

			return true; // Usuario inserido
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Falha ao inserir o produto
		}
	}
	

	
	public static Usuario LogarUsuario(String Nome, String senha) {
	    Usuario usuario = null;

	    String query = "SELECT * FROM Usuarios WHERE NOME = ? AND SENHA = ?";
	    try (Connection conexao = Conexao.getConnection();
	         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

	        preparedStatement.setString(1, Nome);
	        preparedStatement.setString(2, senha);
	
	        ResultSet resultSet = preparedStatement.executeQuery();

	        
	        if (resultSet.next()) {
	            usuario = new Usuario();
	            usuario.setNome(resultSet.getString("NOME"));
	            usuario.setCPF(resultSet.getString("CPF"));
	            usuario.setSenha(resultSet.getString("SENHA"));
	            
	            // Defina outros atributos necessários
	            usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
	            System.out.println("Nome: " + usuario.getNome());
	            System.out.println("CPF: " + usuario.getCPF());
	            // Adicione outras instruções de impressão para os valores necessários

	        } else {
	            System.out.println("Nenhum usuário encontrado com essas credenciais.");
	        }
	    
	       
	   

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return usuario;
	}
	

	
	public Contato buscarContatoPorUsuario(Connection conexao, String nome) {
	    Contato contato = null;
	    String query = "SELECT c.* FROM Usuarios u INNER JOIN Contato c ON u.ID_USUARIO = c.ID_USUARIO WHERE u.NOME = ?";
	  
	    try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
	        preparedStatement.setString(1, nome);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                contato = new Contato(); // Aqui você instancia o objeto Contato
	                contato.setIdContato(resultSet.getInt("ID_CONTATO"));
	                contato.setIdUsuario(resultSet.getInt("ID_USUARIO"));
	                contato.setNome(resultSet.getString("NOME"));
	                contato.setEmail(resultSet.getString("EMAIL"));
	                // ... Defina outros atributos necessários aqui
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (contato != null) {
	        System.out.println("Nome: " + contato.getNome());
	    } else {
	        System.out.println("Contato não encontrado para o usuário: " + nome);
	    }

	    return contato;
	}


}

	

	

	

	
	
	

	
	
	 

