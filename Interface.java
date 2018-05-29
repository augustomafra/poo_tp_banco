// Universidade Federal de Minas Gerais
// Programacao Orientada a Objetos
// 2018-1
//
// Trabalho Pratico 1
// Sistema de Gerenciamento de Banco
//
// Andre Lage
// Augusto Mafra

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import banco.Banco;
import banco.Cliente;

public class Interface {

/************************* Criar Comandos aqui dentro *************************/
    static String[] comandos = {"ajuda",
                                "cadastrar",
                                "criar_conta",
                                "cobrar_tarifa",
                                "cobrar_cpmf",
                                "deposito",
                                "excluir_cliente",
                                "excluir_conta",
                                "extrato",
                                "listar_clientes",
                                "listar_contas",
                                "saldo",
                                "saque",
                                "transferencia",
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
        } else if (input.equals("cobrar_tarifa")) {
            cobrarTarifa();
        } else if (input.equals("cobrar_cpmf")) {
            cobrarCPMF();
        } else if (input.equals("deposito")) {
            deposito();
        } else if (input.equals("excluir_cliente")) {
            excluirCliente();
        } else if (input.equals("excluir_conta")) {
            excluirConta();
        } else if (input.equals("extrato")) {
            extrato();
        } else if (input.equals("listar_clientes")) {
            listarClientes();
        } else if (input.equals("listar_contas")) {
            listarContas();
        } else if (input.equals("saldo")) {
            saldo();
        } else if (input.equals("saque")) {
            saque();
        } else if (input.equals("transferencia")) {
            transferencia();
        // TODO comandos salvar e restaurar nao devem existir
        } else if (input.equals("salvar")) {
            salvar();
        } else if (input.equals("restaurar")) {
            restaurar();
        // TODO comandos salvar e restaurar nao devem existir
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
        System.out.println("Insira informacoes para cadastro do cliente:");
        System.out.print("\t>>> Nome: ");
        String nome = scan.nextLine();
        System.out.print("\t>>> CPF/CNPJ: ");
        String cpf_cnpj = scan.nextLine();
        System.out.print("\t>>> Endereco: ");
        String endereco = scan.nextLine();
        System.out.print("\t>>> Telefone: ");
        String telefone = scan.nextLine();
        System.out.print("\t>>> Confirmar cadastro de cliente? [s/n]: ");
        String confirmacao = scan.nextLine();
        if (confirmacao.equals("s")) {
            boolean status = banco.addCliente(new Cliente(nome, cpf_cnpj, endereco, telefone));
            if (status) {
                System.out.println("Cadastro do cliente concluido com sucesso");
            } else {
                System.out.println("ERRO: Ja existe cliente cadastrado com o CPF/CNPJ especificado");
            }
        } else {
            System.out.println("Cadastro do cliente foi cancelado pelo usuario");
        }
    }

    private static void criarConta() {
        System.out.println("Insira informacoes para criacao da conta:");
        System.out.print("\t>>> CPF/CNPJ: ");
        String cpf_cnpj = scan.nextLine();
        banco.Cliente cliente = banco.getCliente(cpf_cnpj);
        if (cliente == null){
            System.out.println("ERRO: Nenhum cliente cadastrado com CPF/CNPJ " + cpf_cnpj);
            return;
        }
        banco.Conta conta = banco.criaConta(cliente);
        System.out.println("Criacao da conta numero " + conta.getNumConta() +
                           " para " + cliente.getNome() +
                           " concluida com sucesso");
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
        System.out.println("Insira informacoes para o deposito:");
        System.out.print("\t>>> Conta para deposito: ");
        int numConta;
        try {
            numConta = Integer.parseInt(scan.nextLine());
        } catch(NumberFormatException e) {
            numConta = 0; // usuario digitou qualquer coisa que nao e' int
        }
        System.out.print("\t>>> Valor: ");
        double valor;
        try {
            valor = Double.parseDouble(scan.nextLine());
        } catch(NumberFormatException e) {
            valor = 0; // usuario digitou qualquer coisa que nao e' double
        }
        System.out.print("\t>>> Confirmar deposito de R$" + valor + " na conta " + numConta + "? [s/n]: ");
        String confirmacao = scan.nextLine();
        if (confirmacao.equals("s")) {
            boolean status = banco.deposito(numConta, valor);
            if (status) {
                System.out.println("Deposito concluido com sucesso");
            } else {
                System.out.println("ERRO: Nenhuma conta com numero " + numConta + " encontrada");
            }
        } else {
            System.out.println("Deposito cancelado pelo usuario");
        }
    }

    private static void saque() {
        System.out.println("Insira informacoes para o saque:");
        System.out.print("\t>>> Conta para saque: ");
        int numConta;
        try {
            numConta = Integer.parseInt(scan.nextLine());
        } catch(NumberFormatException e) {
            numConta = 0; // usuario digitou qualquer coisa que nao e' int
        }
        System.out.print("\t>>> Valor: ");
        double valor;
        try {
            valor = Double.parseDouble(scan.nextLine());
        } catch(NumberFormatException e) {
            valor = 0; // usuario digitou qualquer coisa que nao e' double
        }
        System.out.print("\t>>> Confirmar saque de R$" + valor + " da conta " + numConta + "? [s/n]: ");
        String confirmacao = scan.nextLine();
        if (confirmacao.equals("s")) {
            boolean status = banco.saque(numConta, valor);
            if (status) {
                System.out.println("Saque concluido com sucesso");
            } else {
                System.out.println("ERRO: Saldo da conta insuficiente para saque");
            }
        } else {
            System.out.println("Saque cancelado pelo usuario");
        }
    }

    private static void transferencia() {
        System.out.println("Efetuando transferencia");
        // TODO preencher funcao
    }

    private static void cobrarTarifa() {
        System.out.println("Cobrando tarifa");
        // TODO preencher funcao
    }

    private static void cobrarCPMF() {
        System.out.println("Cobrando CPMF");
        // TODO preencher funcao
    }

    private static void saldo() {
        System.out.println("Obtendo saldo");
        // TODO preencher funcao
    }

    private static void extrato() {
        System.out.println("Obtendo extrato");
        // TODO preencher funcao
    }

    private static void listarClientes() {
        System.out.println("Lista de clientes:");
        ArrayList<banco.Cliente> listaDeClientes = banco.getClientes();
        for (banco.Cliente cliente : listaDeClientes){
            System.out.println(cliente);
        }
    }

    private static void listarContas() {
        System.out.println("Lista de contas:");
        ArrayList<banco.Conta> listaDeContas = banco.getContas();
        for (banco.Conta conta : listaDeContas){
            System.out.println(conta);
        }
    }

    private static void salvar() {
        if (!banco.salvar(Paths.get("database.txt"))) {
            System.out.println("ERRO: O arquivo nao foi salvo");
        }
    }

    private static void restaurar() {
        banco = new Banco(Paths.get("database.txt"));
    }
/************************* Criar Comandos aqui dentro *************************/

    private static void iniciarLinhaDeComando() {
        scan = new Scanner(System.in);
        banco = new Banco("pooBank");

        System.out.println("Universidade Federal de Minas Gerais");
        System.out.println("Programacao Orientada a Objetos");
        System.out.println("2018-1\n");
        System.out.println("Trabalho Pratico 1");
        System.out.println("Sistema de Gerenciamento de Banco\n");
        System.out.println("Andre Lage");
        System.out.println("Augusto Mafra\n");
        System.out.println("\nEntre o comando 'ajuda' para obter uma lista dos comandos disponiveis\n");
    }

    public static void main(String[] args) {
        iniciarLinhaDeComando();
        boolean status = true;
        while (status) {
            status = executarLinhaDeComando();
        }
    }

    private static Banco banco;
    private static Scanner scan;
}
