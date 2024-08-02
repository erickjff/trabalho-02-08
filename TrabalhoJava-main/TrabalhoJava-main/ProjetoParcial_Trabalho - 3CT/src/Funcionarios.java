import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario ( Nome VARCHAR, Numero INTEGER, Data INTEGER)");

        //Insira seu código aqui

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserifuncionario(String nome, int numero, String data) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionario (Nome,Numero,Data) VALUES(?,?,?)")) {
            insertStatement.setString(1, nome);
            insertStatement.setInt(2, numero);
            insertStatement.setString(3, data);
            insertStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("funcionario inserido.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
            //Insira seu código aqui
        }
    }

    public void lerFuncionario(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario... //Insira seu código aqui ")) {



        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deletefuncionario(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario WHERE Nome=?")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("funcionario deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario: " + e.getMessage());
            //Insira seu código aqui
        }
    }
}
