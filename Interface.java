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

    private static Comando executarLinhaDeComando() {
        System.out.print("> ");
        String input = scan.nextLine();
        Comando comando = reconhecerComando(input);
        if (comando == Comando.AJUDA) {
            mostrarListaDeComandos();
        } else if (comando == Comando.SAIR) {
            System.out.println("Encerrando sistema de gerenciamento de banco...");
        } else if (comando == Comando.ERRO) {
            System.out.println("ERRO: Comando desconhecido");
        }
        return comando;
    }

    // Recohnece uma string como sendo um comando listado no enum 'Comando'
    // Se a string nao corresponder a nenhum item do enum, retorna o enum ERRO
    private static Comando reconhecerComando(String cmd_string) {
        if (cmd_string.equals("ajuda")) {
            return Comando.AJUDA;
        } else if (cmd_string.equals("sair")) {
            return Comando.SAIR;
        } else {
            return Comando.ERRO;
        }
    }

    private static void mostrarListaDeComandos() {
        System.out.println("Lista de comandos:");
        System.out.println("ajuda");
        System.out.println("sair");
    }

    public static void main(String[] args) {
        iniciarLinhaDeComando();
        Comando comando = Comando.ERRO;
        while (comando != Comando.SAIR) {
            comando = executarLinhaDeComando();
        }
    }

    private static enum Comando {
        AJUDA,
        SAIR,
        ERRO
    }
    private static Scanner scan;
}
