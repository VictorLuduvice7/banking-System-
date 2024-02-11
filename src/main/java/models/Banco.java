package models;
import java.util.HashMap;
import java.util.Map;

// Criando a classe Banco e suas propridade !
public class Banco {
    private String nome;
    private String senha;
    private Map<String, Double> contas;  // Map: É uma interface que mapeia chaves a valores. (ira assosiar String e valores )


    public Banco(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.contas = new HashMap<>();
    }


    // criando as funções
    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public void adicionarValor(String usuario, double valor) {
        contas.put(usuario, contas.getOrDefault(usuario, 0.0) + valor); // getOrDefault() para recuperar o saldo associado a um determinado usuario em um mapa chamado contas
    }

    public void removerValor(String usuario, double valor) {
        contas.put(usuario, contas.getOrDefault(usuario, 0.0) - valor);
    }

    public double getSaldo(String usuario) {
        return contas.getOrDefault(usuario, 0.0);
    }
}
