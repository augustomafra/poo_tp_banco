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
    static String[] comandos = {"ajuda",
                                "cadastrar",
                                "criar_conta",
                                "deposito",
                                "excluir_cliente",
                                "excluir_conta",
                                "saque",
                                "sair"};

    private static boolean executarLinhaDeComando() {
        System.out.print("> ");
        String input = scan.nextLine();
        boolean status = true;
        if (input.equals("ajuda")) {
            mostrarListaDeComandos();
        } else if (input.equals("cadastrar")) {
            cadastrarCliente();
        } else if (input.equals("criar_conta")) {
            criarConta();
        } else if (input.equals("deposito")) {
            deposito();
        } else if (input.equals("excluir_cliente")) {
            excluirCliente();
        } else if (input.equals("excluir_conta")) {
            excluirConta();
        } else if (input.equals("saque")) {
            saque();
        } else if (input.equals("sair")) {
            System.out.println("Encerrando sistema de gerenciamento de banco...");
            status = false;
        } else {
            System.out.println("ERRO: Comando desconhecido");
        }
        return status;
    }

    // Funcoes auxiliares para os comandos
    private static void mostrarListaDeComandos() {
        System.out.println("Lista de comandos:");
        for (int i = 0; i < comandos.length; i++){
            System.out.println(comandos[i]);
        }
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

    private static void saque() {
        System.out.println("Efetuando saque");
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
        boolean status = true;
        while (status) {
            status = executarLinhaDeComando();
        }
    }

    private static Scanner scan;
}
