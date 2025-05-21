public class Veterinario extends Funcionario {
    private String especialidade;
    private String crmv;

    public Veterinario(String nome, String endereco, double salario, String especialidade, String crmv) {
        super(nome, endereco, salario);
        this.especialidade = especialidade;
        this.crmv = crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrmv() {
        return crmv;
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidade: " + especialidade + ", CRMV: " + crmv;
    }
}