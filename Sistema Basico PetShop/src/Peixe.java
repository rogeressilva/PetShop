public class Peixe extends Pet {
    private String tipoAgua;

    public Peixe(String nome, String raca, int idade, String tipoAgua) {
        super(nome, raca, idade, "Peixe");
        this.tipoAgua = tipoAgua;
    }

    public String getTipoAgua() {
        return tipoAgua;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Água: " + tipoAgua;
    }
}
