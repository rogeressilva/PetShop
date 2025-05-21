public class Ave extends Pet {
    private String tamanhoBico;

    public Ave(String nome, String raca, int idade, String tamanhoBico) {
        super(nome, raca, idade, "Ave");
        this.tamanhoBico = tamanhoBico;
    }

    public String getTamanhoBico() {
        return tamanhoBico;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho do Bico: " + tamanhoBico;
    }
}