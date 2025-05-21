//Classe Funcionario
public class Funcionario {
    //Atributos basicos
    private String nome;
    private String endereco;
    private double salario;
 
    // Construtor
    public Funcionario(String nome, String endereco, double salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return "Funcionário: " + nome + ", Endereço: " + endereco + ", Salário: R$" + salario;
    }
}