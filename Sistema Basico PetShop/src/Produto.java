//Classe Produto
public class Produto {
    //Atributos basicos
    private String nome;
    private double valor;
    private String descricao;
    private int quantidade;

    //Construtor
    public Produto(String nome, double valor, String descricao, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor + " (" + quantidade + " em estoque)";
    }
}