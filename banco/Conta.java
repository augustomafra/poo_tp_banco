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

class Conta {
    private int numConta;
    private double saldo;
    private Cliente cliente;
    private ArrayList<banco.Movimentacao> movimentacoes;
    // TODO Descobrir para que proximoNumConta serve
    static private int proximoNumConta;
}
