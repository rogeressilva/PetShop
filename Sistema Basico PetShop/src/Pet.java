public abstract class Pet {
    private String nome;
    private String raca;
    private int idade;
    private String tipo;

    public Pet(String nome, String raca, int idade, String tipo) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome + " (" + raca + ", " + idade + " anos, " + tipo + ")";
    }
}