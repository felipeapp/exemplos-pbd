package injecao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/agenda";
        String usuario = "root";
        String senha = "123456";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
                Scanner leitor = new Scanner(System.in)) {

            System.out.print("Digite o e-mail do contato: ");
            var email = leitor.nextLine();

            /*
             * Este é um exemplo de SQL Injection, NÃO use desta forma! Digitar ' or '1'='1
             * produzirá o SQL: delete from contato where email = '' or '1'='1' e apagará
             * todos os dados da tabela contato.
             */
            String sql = "delete from contato where email = '" + email + "'";
            System.out.println("SQL: " + sql);
            var linhas = conexao.prepareStatement(sql).executeUpdate();
            System.out.println("Linhas afetadas = " + linhas);

            if (linhas > 0) {
                System.out.println("Remoção realizada com sucesso!");
            } else {
                System.out.println("E-mail não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar remoção!");
            // e.printStackTrace();
        }

    }

}
