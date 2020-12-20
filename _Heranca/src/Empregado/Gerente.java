package Empregado;
public class Gerente extends Empregado{
    private String departamentoTrabalhado;
    public Gerente(String departamentoTrabalhado, String nome, float salario) {
        super(nome, salario);
        this.departamentoTrabalhado = departamentoTrabalhado;
    }
    public String getDepartamentoTrabalhado() {
        return departamentoTrabalhado;
    }
    public void setDepartamentoTrabalhado(String departamentoTrabalhado) {
        this.departamentoTrabalhado = departamentoTrabalhado;
    }
    @Override
    public String toString() {
        return "\nDepartamento Trabalhado: " + departamentoTrabalhado 
             + super.toString();
    }
}








