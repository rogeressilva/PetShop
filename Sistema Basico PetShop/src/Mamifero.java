public class Mamifero extends Pet {
    private String pelagem;

    public Mamifero(String nome, String raca, int idade, String pelagem) {
        super(nome, raca, idade, "Mamífero");
        this.pelagem = pelagem;
    }

    public String getPelagem() {
        return pelagem;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pelagem: " + pelagem;
    }
}