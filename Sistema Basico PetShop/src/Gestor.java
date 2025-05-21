public class Gestor extends Funcionario {
    private String departamento;
    private double bonus;

    public Gestor(String nome, String endereco, double salario, String departamento, double bonus) {
        super(nome, endereco, salario);
        this.departamento = departamento;
        this.bonus = bonus;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento + ", Bônus: R$" + bonus;
    }
}