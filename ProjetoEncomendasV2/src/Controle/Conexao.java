package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/ProjetoProg3";
        String user = "postgres";
        String password = "postgres";

        try {
            // Carregando o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Criando uma conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, user, password);

            // Retornando a conexão criada
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Se ocorrer um erro, retorne null
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Se ocorrer um erro, retorne null
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection != null) {
            // Você pode usar 'connection' para executar consultas e outras operações no banco de dados

            // Não se esqueça de fechar a conexão quando terminar
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
