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

public class Banco {
    public Banco(String nome) {
        nomeBanco = nome;
        nomeBanco = new String();
        clientes = new ArrayList<banco.Cliente>();
        contas = new ArrayList<banco.Conta>();
    }
    private String nomeBanco;
    private ArrayList<banco.Cliente> clientes;
    private ArrayList<banco.Conta> contas;
}
