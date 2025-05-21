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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return nome + " - R$" + valor + " (" + quantidade + " em estoque)";
    }
}