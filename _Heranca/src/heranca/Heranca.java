package heranca;
import Empregado.Gerente;
import Empregado.Vendedor;
import java.util.ArrayList;
import java.util.Scanner;
public class Heranca {
    static Scanner input = new Scanner(System.in);
    static final int opcaoEncerraPrograma = 0;
    static final int quantidadeFuncionalidadesPrograma = 8;
    public static void main(String[] args) {
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
        menuApresentacaoPrograma();
        int opcaoFuncionalidades;
        do{
            do{
                opcaoFuncionalidades = atribuirInt(menuFuncionalidades());
            }while(opcaoFuncionalidades < opcaoEncerraPrograma
                || opcaoFuncionalidades > quantidadeFuncionalidadesPrograma);
            switch(opcaoFuncionalidades){
                case 1 -> contratarVendedor(vendedores);
                case 2 -> demitirVendedor(vendedores);
                case 3 -> contratarGerente(gerentes);
                case 4 -> demitirGerente(gerentes);
                case 5 ->
                {
                    var vendedorAchado = procurarVendedor(vendedores);
                    printarVendedor(vendedorAchado);
                }
                case 6 -> 
                {
                    var gerenteAchado = procurarGerente(gerentes); 
                    printarGerente(gerenteAchado);
                }
                case 7 -> cadastrarVendaVendedor(vendedores);
                case 8 -> printarDadosFuncionarios(gerentes, vendedores);
                case 0 -> encerraPrograma();
            }
        }while(opcaoFuncionalidades != opcaoEncerraPrograma);
    }
    private static void menuApresentacaoPrograma() {
        System.out.println("\tPrograma Herança"
                         + "\n\tWarley Júnio Martins Vieira"
                         + "\n\tProgramação de Computadores 2");    }
    private static String menuFuncionalidades(){
        return "\nDigite a opção desejada:"
             + "\n(1). Contratar novo vendedor                (2). Demitir um vendedor"
             + "\n(3). Contratar novo gerente                 (4). Demitir um gerente"
             + "\n(5). Procurar vendedor                      (6). Procurar gerente "
             + "\n(7). Cadastrar nova vanda do vendedor       (8). Printar dados dos Funcionarios"
             + "\n(0). Encerrar"
             + "\nOpção desejada: ";
    }
    public static void contratarVendedor(ArrayList<Vendedor> vendedores){
        var mensagemNome = "\nDigite o nome do vendedor: ";
        var nome = atribuirString(mensagemNome);
        var mensagemSalario = "Digite o salario do vendedor: ";
        var salario = atribuirFloat(mensagemSalario);
        float percentualComissaoVendedor;
        do{
            var mensagemComissao = "Digite o valor de comissão do vendedor (0 a 1): ";
            percentualComissaoVendedor = atribuirFloat(mensagemComissao);
        }while(percentualComissaoVendedor < 0 
            || percentualComissaoVendedor > 1);
        vendedores.add(new Vendedor( percentualComissaoVendedor, nome, salario));
    }
    public static void demitirVendedor(ArrayList<Vendedor> vendedores){
        var vendedorDemitido = procurarVendedor(vendedores);
        vendedores.remove(vendedorDemitido);
    }
    public static void contratarGerente(ArrayList<Gerente> gerentes){
        var mensagemNome = "\nDigite o nome do gerente: ";
        var nome = atribuirString(mensagemNome);
        var mensagemSalario = "Digite o salario do gerente: ";
        var salario = atribuirFloat(mensagemSalario);
        var mensagemSetorTrabalhado = "Digite o setor do gerente: ";
        var setorTrabalhado = atribuirString(mensagemSetorTrabalhado);
        gerentes.add(new Gerente( setorTrabalhado, nome, salario));
    }
    public static void demitirGerente(ArrayList<Gerente> gerentes){
        var gerenteDemitido = procurarGerente(gerentes);
        gerentes.remove(gerenteDemitido);
    }
    public static Vendedor procurarVendedor(ArrayList<Vendedor> vendedores){
        Vendedor vendedorProcurado;
        do{
            var mensagemNome = "\nDigite o nome do vendedor: ";
            var nomeVendedor = atribuirString(mensagemNome);
            vendedorProcurado = vendedores
                                          .stream()
                                          .filter(x -> x.getNome().equals(nomeVendedor))
                                          .findFirst()
                                          .orElse(null);
        }while(vendedorProcurado == null);
        return vendedorProcurado;
    }
    public static Gerente procurarGerente(ArrayList<Gerente> gerentes){
        Gerente gerenteProcurado;
        do{
            var mensagemNome = "\nDigite o nome do gerente: ";
            var nomeVendedor = atribuirString(mensagemNome);
            gerenteProcurado = gerentes
                                       .stream()
                                       .filter(x -> x.getNome().equals(nomeVendedor))
                                       .findFirst()
                                       .orElse(null);
        }while(gerenteProcurado == null);
        return gerenteProcurado;
    }       
    public static void cadastrarVendaVendedor(ArrayList<Vendedor>vendedores){
        var vendedor = procurarVendedor(vendedores);
        var mensagemNovaVenda = "\nDigite o valor vendido: ";
        var valorNovaVenda = atribuirFloat(mensagemNovaVenda);
        vendedor.adicionarNovaVenda(valorNovaVenda);
    }
    public static void printarDadosFuncionarios(ArrayList<Gerente> gerentes, ArrayList<Vendedor> vendedores){
        System.out.println("\nGerentes: ");
        gerentes.forEach(gerentePrintado ->
        {
            printarGerente(gerentePrintado);
        });
        System.out.println("\nVendedores: ");
        vendedores.forEach(vendedorPrintado ->
        {
            printarVendedor(vendedorPrintado);
        });
    }
    public static void printarVendedor(Vendedor vendedor){
        System.out.println(vendedor.toString());
    }
    public static void printarGerente(Gerente gerente){
        System.out.println(gerente.toString());
    }  
    private static int atribuirInt(String mensagem) {
        int valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Integer.parseInt(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
            }
        }while(true);
    }
    private static Float atribuirFloat(String mensagem) {
        float valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Float.parseFloat(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
            }
        }while(true);
    }
    private static String atribuirString(String mensagem) {
        String valorAtribuido;
        do{
                System.out.print(mensagem);
                valorAtribuido = input.nextLine();
                if(!valorAtribuido.isEmpty())return valorAtribuido;
        }while(true);
    }
    private static void encerraPrograma() {
        System.out.println("\nPrograma Encerrado!\n");
    }
}





















