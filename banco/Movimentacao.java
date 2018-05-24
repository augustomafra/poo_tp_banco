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

import java.util.GregorianCalendar;

class Movimentacao {
    private GregorianCalendar dataMov;
    private String descricao;
    private char debitoCredito;
    private double valor;

    public 	Movimentacao(String descricao, char debitoCredito, double valor){
    	this.descricao=descricao;
    	this.debitoCredito=debitoCredito;
    	this.valor=valor;
    	//dataMov.
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
}


