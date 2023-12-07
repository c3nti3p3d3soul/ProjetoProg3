package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exemplo {
	public static void main(String[] args) {
		try {
			Connection con = Conexao.getConnection();
// Consulta SQL
			String sql = "SELECT nome, idade FROM clientes WHERE cidade = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "São Paulo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				System.out.println("Nome: " + nome + ", Idade: " + idade);
			}
// Feche recursos
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}