//Classe Pet
public abstract class Pet {
    //Atributos basicos
    private String nome;
    private String raca;
    private int idade;
    private String tipo;

    // Construtor
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() { //Método para retornar uma representação em String do objeto
        return nome + " (" + raca + ", " + idade + " anos, " + tipo + ")";
    }
}