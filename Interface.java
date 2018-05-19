// Universidade Federal de Minas Gerais
// Programacao Orientada a Objetos
// 2018-1
//
// Trabalho Pratico 1
// Sistema de Gerenciamento de Banco
//
// Andre Lage
// Augusto Mafra

import java.util.Scanner;

public class Interface {
    private static void iniciarLinhaDeComando() {
        scan = new Scanner(System.in);

        System.out.println("Universidade Federal de Minas Gerais");
        System.out.println("Programacao Orientada a Objetos");
        System.out.println("2018-1\n");
        System.out.println("Trabalho Pratico 1");
        System.out.println("Sistema de Gerenciamento de Banco\n");
        System.out.println("Andre Lage");
        System.out.println("Augusto Mafra\n");
    }

    private static void executarLinhaDeComando() {
        System.out.print("> ");
        String input = scan.nextLine();
        // TODO Por enquanto a entrada so e' ecoada na saida
        System.out.println(input);
    }

    public static void main(String[] args) {
        iniciarLinhaDeComando();
        while (true) {
            executarLinhaDeComando();
        }
    }

    private static Scanner scan;
}
