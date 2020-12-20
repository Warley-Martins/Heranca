package Empregado;
public class Vendedor extends Empregado{
    private float percentualComissao;
    private float valorVendido;
    public Vendedor(float percentualComissao, String nome, float salario) {
        super(nome, salario);
        this.percentualComissao = percentualComissao;
        this.valorVendido = 0;
    }
    public float getPercentualComissao() {
        return this.percentualComissao;
    }
    public void setPercentualComissao(float percentualComissao) {
        this.percentualComissao = percentualComissao;
    }
    public float calculaSalario(){
        return ((valorVendido * this.percentualComissao) + this.salario);
    }
    public boolean adicionarNovaVenda(float valorNovaVenda){
        if(valorNovaVenda <= 0) return false;
        this.valorVendido += valorNovaVenda;
        return true;
    }
    public float getValorVendido() {
        return valorVendido;
    }
    public void setValorVendido(float valorVendido) {
        this.valorVendido = valorVendido;
    }
    @Override
    public String toString() {
        return  super.toString()
                + "\npercentualComissao: " + getPercentualComissao()*100 + "%" 
                + "\nValor vendido: R$"  + getValorVendido()
                + "\nValor total Salario: R$" + calculaSalario();
    }    
}











