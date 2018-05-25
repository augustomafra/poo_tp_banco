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
import banco.Banco;

public class Interface {

/************************* Criar Comandos aqui dentro *************************/
    private static enum Comando {
        AJUDA,
        CADASTRAR_CLIENTE,
        CRIAR_CONTA,
        DEPOSITO,
        EXCLUIR_CLIENTE,
        EXCLUIR_CONTA,
        SAIR,
        ERRO
    }

    // Recohnece uma string como sendo um comando listado no enum 'Comando'
    // Se a string nao corresponder a nenhum item do enum, retorna o enum ERRO
    private static Comando reconhecerComando(String cmd_string) {
        if (cmd_string.equals("ajuda")) {
            return Comando.AJUDA;
        } else if (cmd_string.equals("cadastrar")) {
            return Comando.CADASTRAR_CLIENTE;
        } else if (cmd_string.equals("criar_conta")) {
            return Comando.CRIAR_CONTA;
        } else if (cmd_string.equals("deposito")) {
            return Comando.DEPOSITO;
        } else if (cmd_string.equals("excluir_cliente")) {
            return Comando.EXCLUIR_CLIENTE;
        } else if (cmd_string.equals("excluir_conta")) {
            return Comando.EXCLUIR_CONTA;
        } else if (cmd_string.equals("sair")) {
            return Comando.SAIR;
        } else {
            return Comando.ERRO;
        }
    }

    private static Comando executarLinhaDeComando() {
        System.out.print("> ");
        String input = scan.nextLine();
        Comando comando = reconhecerComando(input);
        if (comando == Comando.AJUDA) {
            mostrarListaDeComandos();
        } else if (comando == Comando.CADASTRAR_CLIENTE) {
            cadastrarCliente();
        } else if (comando == Comando.CRIAR_CONTA) {
            criarConta();
        } else if (comando == Comando.DEPOSITO) {
            deposito();
        } else if (comando == Comando.EXCLUIR_CLIENTE) {
            excluirCliente();
        } else if (comando == Comando.EXCLUIR_CONTA) {
            excluirConta();
        } else if (comando == Comando.SAIR) {
            System.out.println("Encerrando sistema de gerenciamento de banco...");
        } else if (comando == Comando.ERRO) {
            System.out.println("ERRO: Comando desconhecido");
        }
        return comando;
    }

    // Funcoes auxiliares para os comandos
    private static void mostrarListaDeComandos() {
        System.out.println("Lista de comandos:");
        System.out.println("ajuda");
        System.out.println("cadastrar");
        System.out.println("criar_conta");
        System.out.println("deposito");
        System.out.println("excluir_cliente");
        System.out.println("excluir_conta");
        System.out.println("sair");
    }

    private static void cadastrarCliente() {
        System.out.println("Cadastrando cliente");
        // TODO preencher funcao
    }

    private static void criarConta() {
        System.out.println("Criando conta");
        // TODO preencher funcao
    }

    private static void excluirCliente() {
        System.out.println("Excluindo cliente");
        // TODO preencher funcao
    }

    private static void excluirConta() {
        System.out.println("Excluindo conta");
        // TODO preencher funcao
    }

    private static void deposito() {
        System.out.println("Efetuando deposito");
        // TODO preencher funcao
    }
/************************* Criar Comandos aqui dentro *************************/

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

    public static void main(String[] args) {
        Banco pooBank = new Banco("pooBank");
        iniciarLinhaDeComando();
        Comando comando = Comando.ERRO;
        while (comando != Comando.SAIR) {
            comando = executarLinhaDeComando();
        }
    }

    private static Scanner scan;
}
