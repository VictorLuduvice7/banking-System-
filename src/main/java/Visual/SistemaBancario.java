package Visual;
import models.Banco;
import models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Parte do Sistema do banco
public class SistemaBancario {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Menu do Sistema !
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Criar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Criar banco");
            System.out.println("4. Acessar banco");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    criarBanco();
                    break;
                case 4:
                    acessarBanco();
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // criando funçoes para cada opção do Menu!
    private static void cadastrarUsuario() {
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do usuário: ");
        String cpf = scanner.nextLine();
        usuarios.add(new Usuario(nome, cpf));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios(){
        System.out.println("Lista De Usuários:");
        for (Usuario usuario : usuarios){
            System.out.println("- Nome: " + usuario.getNome());
            System.out.println("  ID: " + usuario.getId());
            System.out.println("  CPF: " + usuario.getCpf());
        }
    }

    private static void criarBanco() {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = encontrarUsuarioPorNome(nomeUsuario);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.print("Digite a senha (4 dígitos): ");
        String senha = scanner.nextLine();
        Banco banco = new Banco(nomeUsuario, senha);
        System.out.println("Banco criado com sucesso para o usuário: " + nomeUsuario);
        // Aqui você pode adicionar o banco ao usuário se precisar
    }


    // Bank dos Usuários !
    private static void acessarBanco() {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuario = encontrarUsuarioPorNome(nomeUsuario);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Banco banco = encontrarBancoPorUsuario(nomeUsuario);
        if (banco == null || !banco.verificarSenha(senha)) {
            System.out.println("Acesso negado.");
            return;
        }
        while (true) {
            System.out.println("1. Adicionar valor");
            System.out.println("2. Remover valor");
            System.out.println("3. Ver saldo");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    double valorAdicionar = scanner.nextDouble();
                    banco.adicionarValor(nomeUsuario, valorAdicionar);
                    System.out.println("Valor adicionado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    double valorRemover = scanner.nextDouble();
                    banco.removerValor(nomeUsuario, valorRemover);
                    System.out.println("Valor removido com sucesso.");
                    break;
                case 3:
                    System.out.println("Saldo: " + banco.getSaldo(nomeUsuario));
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }


    // gerando operações !
    private static Usuario encontrarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

       // ainda vou ajeitar !
   private static Banco encontrarBancoPorUsuario(String nomeUsuario) {return null;}
}
