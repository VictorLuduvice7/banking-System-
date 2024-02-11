package models;


// Criando a classe Usuário e suas propriedade!
public class Usuario {
    private static int contadorId = 0; // criando um contador de Id
    private int id;
    private String nome;
    private String cpf;

    public Usuario(String nome, String cpf) {
        this.id = ++contadorId;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
