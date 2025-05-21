//Classe Gestor herdando da classe Funcionario
public class Gestor extends Funcionario {
    //Atributos especificos
    private String departamento;
    private double bonus;  

    //Construtor
    public Gestor(String nome, String endereco, double salario, String departamento, double bonus) {
        super(nome, endereco, salario);
        this.departamento = departamento;
        this.bonus = bonus;
    }

    //Getters e Setters
    public String getDepartamento() {
        return departamento;
    }

    public double getBonus() {
        return bonus;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override //Para garantir que a assinatura do método esteja correta
    public String toString() {
        return super.toString() + ", Departamento: " + departamento + ", Bônus: R$" + bonus;
    }
}