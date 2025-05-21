//Classe Mamifero herdando da classe Pet
public class Mamifero extends Pet {
    //Atributos especificos
    private String pelagem;   

    //Construtor
    public Mamifero(String nome, String raca, int idade, String pelagem) {
        super(nome, raca, idade, "Mamífero");
        this.pelagem = pelagem;
    }

    //Getters e Setters
    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return super.toString() + ", Pelagem: " + pelagem;
    }
}