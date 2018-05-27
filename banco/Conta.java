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

    public Conta(Conta outra){
        numConta = outra.numConta;
        saldo = outra.saldo;
        cliente = outra.cliente;
        movimentacoes = new ArrayList<banco.Movimentacao>(outra.movimentacoes);
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

    public int getNumConta(){
        return numConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public void creditar(double valor, String descricao){
        saldo += valor;
        movimentacoes.add(new Movimentacao(descricao, 'C', valor));
    }

    public void debitar(double valor, String descricao){
        if (valor > saldo) return;
        saldo -= valor;
        movimentacoes.add(new Movimentacao(descricao, 'D', valor));
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
