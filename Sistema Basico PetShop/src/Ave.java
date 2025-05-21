//Classe Ave herdando da classe Pet
public class Ave extends Pet {
    //Atributos espcificos
    private String tamanhoBico;

    //Construtor
    public Ave(String nome, String raca, int idade, String tamanhoBico) {
        super(nome, raca, idade, "Ave");
        this.tamanhoBico = tamanhoBico;
    }

    //Getters e Setters
    public String getTamanhoBico() {
        return tamanhoBico;
    }

     public void setTamanhoBico(String tamanhoBico) {
        this.tamanhoBico = tamanhoBico;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return super.toString() + ", Tamanho do Bico: " + tamanhoBico;
    }
}