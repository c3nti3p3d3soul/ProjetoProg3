package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.toedter.calendar.JDateChooser;

public class Contato {

	JDateChooser dateChooser = new JDateChooser();
	private int idContato;
	private int idUsuario;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private String bairro;
	private String numeroCasa;
	private String cep;
	private String cidade;
	private String uf;
	private String dataNascimento;

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	
	public boolean inserirContato(Connection conexao) {
	    String query = "INSERT INTO Contato (EMAIL, TELEFONE, ENDERECO, BAIRRO, NUMERO_CASA, CEP, CIDADE, UF, DATA_NASCIMENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
	        preparedStatement.setString(1, this.getEmail());
	        preparedStatement.setString(2, this.getTelefone());
	        preparedStatement.setString(3, this.getEndereco());
	        preparedStatement.setString(4, this.getBairro());
	        preparedStatement.setString(5, this.getNumeroCasa());
	        preparedStatement.setString(6, this.getCep());
	        preparedStatement.setString(7, this.getCidade());
	        preparedStatement.setString(8, this.getUf());
	        preparedStatement.setString(9, this.getDataNascimento());
	        
	        int linhasAfetadas = preparedStatement.executeUpdate();
	        return linhasAfetadas > 0;
	        
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
		return false;
    }
}
	
	



	
	
	
