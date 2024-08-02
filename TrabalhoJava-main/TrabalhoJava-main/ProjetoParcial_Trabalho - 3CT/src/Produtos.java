import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Produtos {



    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto ( Nome VARCHAR, Quantidade INTEGER, Valor INTEGER)");

            //Insira seu código aqui

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirProdutos(String nome, int Quantidade, Double Valor) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto (Nome,Quantidade,Valor) VALUES(?,?,?)")) {
            insertStatement.setString(1, nome);
            insertStatement.setInt(2, Quantidade);
            insertStatement.setDouble(3, Valor);
            insertStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("produto inserido.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Produto: " + e.getMessage());
            //Insira seu código aqui

        }
    }

    public void lerProduto(String nome) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Produto WHERE Nome=?")) {
            selectStatement.setString(1, nome);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String usuario = resultSet.getString("Nome");
                int quantidade = resultSet.getInt("quantidade");
                Double valor = resultSet.getDouble("valor");
                if (nome.equals(usuario)){
                    System.out.println("o produto selecionado é"+usuario);

                }

            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }


    public void deleteProduto(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto WHERE Nome=?")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Cliente deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
            //Insira seu código aqui


        }
    }
}
