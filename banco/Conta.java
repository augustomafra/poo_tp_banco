// Universidade Federal de Minas Gerais
// Programacao Orientada a Objetos
// 2018-1
//
// Trabalho Pratico 1
// Sistema de Gerenciamento de Banco
//
// Andre Lage
// Augusto Mafra

package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

public class Conta {
    private int numConta;
    private double saldo;
    private Cliente cliente;
    private ArrayList<banco.Movimentacao> movimentacoes;
    static private int proximoNumConta = 0;

    public Conta(Cliente cliente){
        numConta = proximoNumConta++;
        saldo = 0;
        this.cliente = cliente;
        this.movimentacoes = new ArrayList<banco.Movimentacao>();
    }

    // Para restaurar uma conta a partir do arquivo
    public Conta(int numConta,
                 double saldo,
                 ArrayList<banco.Movimentacao> movimentacoes,
                 banco.Cliente cliente){
        this.numConta = numConta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.movimentacoes = movimentacoes;
    }

    // Para restaurar o contador de contas a partir do arquivo
    static public void restaurarContadorDeContas(int n) {
        proximoNumConta = n + 1;
    }

    public Conta(Conta outra){
        numConta = outra.numConta;
        saldo = outra.saldo;
        cliente = outra.cliente;
        movimentacoes = new ArrayList<banco.Movimentacao>(outra.movimentacoes);
    }

    // Preenche a lista data com os dados da conta
    public void formatarDados(List<String> data) {
        data.add(String.valueOf(numConta));
        data.add(String.valueOf(saldo));
        data.add(cliente.getCpf_cnpj());
        data.add("poo_tp_movimentacoes_database_inicio");
        for (banco.Movimentacao m : movimentacoes) {
            m.formatarDados(data);
        }
        data.add("poo_tp_movimentacoes_database_fim");
    }

    // Para impressao com System.out.println na Interface
    public String toString(){
        String ret = new String();
        ret += "\tNumero da Conta: " + numConta + "\n";
        ret += "\tSaldo: " + saldo + "\n";
        ret += "\tCPF/CNPJ do Cliente: " + cliente.getCpf_cnpj() + "\n";
        ret += "\n";
        return ret;
    }

    public Cliente getCliente(){
        Cliente copia = new Cliente(cliente);
        return copia;
    }

    public int getNumConta(){
        return numConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean creditar(double valor, String descricao){
        saldo += valor;
        return movimentacoes.add(new Movimentacao(descricao, 'C', valor));
    }

    public boolean debitar(double valor, String descricao){
        if (valor > saldo) return false;
        saldo -= valor;
        return movimentacoes.add(new Movimentacao(descricao, 'D', valor));
    }

    public ArrayList<banco.Movimentacao> getExtrato(GregorianCalendar dataInicial, GregorianCalendar dataFinal){
        ArrayList<banco.Movimentacao> extrato = new ArrayList<banco.Movimentacao>();
        for (banco.Movimentacao mov : movimentacoes){
            GregorianCalendar data = mov.getDataMov();
            if ((data.after(dataInicial) &&
                 data.before(dataFinal)) ||
                 data.compareTo(dataInicial) == 0 ||
                 data.compareTo(dataFinal) == 0){
                extrato.add(mov);
            }
        }
        return extrato;
    }

    public ArrayList<banco.Movimentacao> getExtrato(GregorianCalendar dataInicial){
        GregorianCalendar dataFinal = new GregorianCalendar(); // data atual
        return getExtrato(dataInicial, dataFinal);
    }

    public ArrayList<banco.Movimentacao> getExtrato(){
        GregorianCalendar dataInicial = new GregorianCalendar();
        GregorianCalendar dataFinal = new GregorianCalendar();
        dataInicial.set(GregorianCalendar.DAY_OF_MONTH, 1);
        dataFinal.set(GregorianCalendar.DAY_OF_MONTH, dataFinal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        return getExtrato(dataInicial, dataFinal);
    }
}
