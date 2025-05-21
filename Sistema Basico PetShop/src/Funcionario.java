public class Funcionario {
    private String nome;
    private String endereco;
    private double salario;

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

    @Override
    public String toString() {
        return "Funcionário: " + nome + ", Endereço: " + endereco + ", Salário: R$" + salario;
    }
}