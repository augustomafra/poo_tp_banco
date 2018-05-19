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
    Banco(String nome) {
        nomeBanco = nome;
    }
    String nomeBanco;
    ArrayList clientes;
    ArrayList contas;
}
