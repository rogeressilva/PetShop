//Classe Peixe herdando da classe Pet
public class Peixe extends Pet {
    //Atributos especificos
    private String tipoAgua;   

    //Construtor
    public Peixe(String nome, String raca, int idade, String tipoAgua) {
        super(nome, raca, idade, "Peixe");
        this.tipoAgua = tipoAgua;
    }

    //Getters e Setters
    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return super.toString() + ", Tipo de Água: " + tipoAgua;
    }
}
