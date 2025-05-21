//Classe Veterinario herdando da classe Funcionario
public class Veterinario extends Funcionario {
    //Atributos especificos
    private String especialidade;  

    //Construtor
    public Veterinario(String nome, String endereco, double salario, String especialidade) {
        super(nome, endereco, salario);
        this.especialidade = especialidade;
    }

    //Getters e Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return super.toString() + ", Especialidade: " + especialidade;
    }
}