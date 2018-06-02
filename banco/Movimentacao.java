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

import java.util.List;
import java.util.GregorianCalendar;

public class Movimentacao {
    private GregorianCalendar dataMov;
    private String descricao;
    private char debitoCredito;
    private double valor;

    public 	Movimentacao(String descricao, char debitoCredito, double valor){
    	this.descricao=descricao;
    	this.debitoCredito=debitoCredito;
    	this.valor=valor;
        this.dataMov = new GregorianCalendar(); //data atual do sistema
    }

    // Para restaurar uma movimentacao a partir do arquivo
    public Movimentacao(int ano,
                        int mes,
                        int dia,
                        String descricao,
                        char debitoCredito,
                        double valor) {
        this.dataMov = new GregorianCalendar(ano, mes, dia);
        this.descricao = descricao;
        this.debitoCredito = debitoCredito;
        this.valor = valor;
    }

    // Preenche a lista data com os dados da movimentacao
    public void formatarDados(List<String> data) {
        data.add(String.valueOf(dataMov.get(GregorianCalendar.YEAR)));
        data.add(String.valueOf(dataMov.get(GregorianCalendar.MONTH)));
        data.add(String.valueOf(dataMov.get(GregorianCalendar.DAY_OF_MONTH)));
        data.add(descricao);
        data.add(String.valueOf(debitoCredito));
        data.add(String.valueOf(valor));
    }

    // Para impressao com System.out.println na Interface
    public String toString() {
        String ret = new String();
        ret += "\t" + dataMov.get(GregorianCalendar.DAY_OF_MONTH);
        ret += "/" + (dataMov.get(GregorianCalendar.MONTH) + 1);
        ret += "/" + dataMov.get(GregorianCalendar.YEAR);
        ret += "\t" + descricao;
        ret += "\t" + debitoCredito;
        ret += "\t" + valor;
        ret += "\n";
        return ret;
    }

    public String getDescricao(){
    	return descricao;
    }

   public char getDebitoCredito(){
   		return debitoCredito;

   }

   public double getValor(){
   		return valor;
   }

   public GregorianCalendar getDataMov(){
        return (GregorianCalendar) dataMov.clone();
   }
}


