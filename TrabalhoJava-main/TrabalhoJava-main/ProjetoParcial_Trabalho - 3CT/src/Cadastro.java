import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();
    String nome;
    int quantidade;
    Double valor;
    int numero;
    String data;


    void adicionarProduto(){
        bancoDeDados.connect();
        produtos.createTable();
        System.out.println("Digite seu nome");
        this.nome = scanner.nextLine().replace(" ","");
        System.out.println("Digite sua Quantidade");
        this.quantidade = Integer.parseInt(scanner.nextLine().replace(" ",""));
        System.out.println("Digite seu Valor");
        this.valor = (double) Integer.parseInt(scanner.nextLine().replace(" ",""));

        produtos.inserirProdutos(nome,quantidade,valor);
        System.out.println("Bem vindo(a), " + nome + quantidade + valor);
        produtos.createTable();
        //Insira seu código aqui
        bancoDeDados.close();
    }

    void lerProduto(){
        bancoDeDados.connect();
        System.out.println("Digite seu produto");
        String nome = scanner.nextLine();
        produtos.lerProduto (nome);
        //Insira seu código aqui
        bancoDeDados.close();
    }


    void deletarProduto(){
        bancoDeDados.connect();
        System.out.println("Digite seu produto aqui");
        String nome = scanner.nextLine();
        produtos.deleteProduto (nome);
        //Insira seu código aqui

        bancoDeDados.close();
    }

    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();
        System.out.println("Digite seu nome");
        this.nome = scanner.nextLine().replace(" ","");
        System.out.println("Digite seu numero");
        this.numero = Integer.parseInt(scanner.nextLine().replace(" ",""));
        System.out.println("Digite sua data");
        this.data = scanner.nextLine().replace(" ","");
        funcionarios.inserifuncionario(nome,quantidade,data);
        System.out.println("Bem vindo(a), " + nome + numero + data);

        //Insira seu código aqui


        //Insira seu código aqui

        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();
        System.out.println("Digite seu funcionario aqui");
        String nome = scanner.nextLine();
        funcionarios.deletefuncionario (nome);
        //Insira seu código aqui

        bancoDeDados.close();
    }

    void imprimirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar funcionário");
        System.out.println("6- Deletar funcionário");
        System.out.println("7- Sair");
    }
}
