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

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.GregorianCalendar;

public class Banco {
    public Banco(String nome) {
        nomeBanco = nome;
        clientes = new ArrayList<banco.Cliente>();
        contas = new ArrayList<banco.Conta>();
    }
    private String nomeBanco;
    private ArrayList<banco.Cliente> clientes;
    private ArrayList<banco.Conta> contas;

    public Banco(Path filePath)
    {
        nomeBanco = new String();
        clientes = new ArrayList<banco.Cliente>();
        contas = new ArrayList<banco.Conta>();

        List<String> data = new ArrayList<String>();
        try {
            data = Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            return; // Erro na leitura do arquivo
        }

        ListIterator<String> i = data.listIterator();
        restauraBanco(data, i);
    }

    public boolean salvar(Path filePath)
    {
        List<String> data = new ArrayList<String>();
        data.add("poo_tp_banco_database_inicio");
        data.add(nomeBanco);
        salvaClientes(data);
        salvaContas(data);
        data.add("poo_tp_banco_database_fim");

        try {
            Files.write(filePath, data, Charset.forName("UTF-8"));
        } catch(IOException e) {
            return false; // Erro na escrita do arquivo
        }

        return true;
    }

    public boolean addCliente(banco.Cliente cliente){
        if (getCliente(cliente.getCpf_cnpj()) != null) return false;
        return clientes.add(cliente); // true se adicao foi bem sucedida
    }

    public banco.Cliente getCliente(String cpf_cnpj){
        for (banco.Cliente c : clientes){
            if (c.getCpf_cnpj().equals(cpf_cnpj)){
                banco.Cliente copia = new banco.Cliente(c);
                return copia;
            }
        }
        return null;
    }

    public ArrayList<banco.Cliente> getClientes(){
        ArrayList<banco.Cliente> copia = new ArrayList<banco.Cliente>(clientes);
        return copia;
    }

    private banco.Conta getConta(int numConta){
        for (banco.Conta c : contas){
            if (c.getNumConta() == numConta){
                return c;
            }
        }
        return null;
    }

    public ArrayList<banco.Conta> getContas(){
        ArrayList<banco.Conta> copia = new ArrayList<banco.Conta>(contas);
        return copia;
    }

    public banco.Conta criaConta(banco.Cliente cliente){
        banco.Cliente c = getCliente(cliente.getCpf_cnpj());
        if (c == null) return null;

		banco.Conta conta = new banco.Conta(cliente);
		contas.add(conta);
        banco.Conta copia = new banco.Conta(conta);
        return copia;
	}

    private void restauraBanco(List<String> data, ListIterator<String> i) {
        String info = i.next();
        if (info.equals("poo_tp_banco_database_inicio")) {

            info = i.next();
            while (!info.equals("poo_tp_banco_database_fim")) {
                nomeBanco = info;
                restauraClientes(data, i);
                restauraContas(data, i);
                info = i.next();
            }
        }
    }

    private void restauraClientes(List<String> data, ListIterator<String> i) {
        String info = i.next();
        if (info.equals("poo_tp_clientes_database_inicio")) {

            info = i.next();
            while (!info.equals("poo_tp_clientes_database_fim")) {
                String nome = info;
                String cpf_cnpj = i.next();
                String endereco = i.next();
                String telefone = i.next();
                addCliente(new banco.Cliente(nome, cpf_cnpj, endereco, telefone));
                info = i.next();
            }
        }
    }

    private void salvaClientes(List<String> data) {
        data.add("poo_tp_clientes_database_inicio");
        for (banco.Cliente c : clientes) {
            c.formatarDados(data);
        }
        data.add("poo_tp_clientes_database_fim");
    }

    private void restauraContas(List<String> data, ListIterator<String> i) {
        int maxNumConta = 0;
        String info = i.next();
        if (info.equals("poo_tp_contas_database_inicio")) {

            info = i.next();
            while (!info.equals("poo_tp_contas_database_fim")) {
                int numConta = Integer.parseInt(info);
                double saldo = Double.parseDouble(i.next());
                String cpf_cnpj = i.next();
                ArrayList<banco.Movimentacao> movimentacoes = restauraMovimentacoes(data, i);
                maxNumConta = java.lang.Math.max(numConta, maxNumConta);
                restauraConta(numConta, saldo, movimentacoes, cpf_cnpj);
                info = i.next();
            }
        }
        banco.Conta.restaurarContadorDeContas(maxNumConta);
    }

    private void salvaContas(List<String> data) {
        data.add("poo_tp_contas_database_inicio");
        for (banco.Conta c : contas) {
            c.formatarDados(data);
        }
        data.add("poo_tp_contas_database_fim");
    }

    private ArrayList<banco.Movimentacao> restauraMovimentacoes(List<String> data, ListIterator<String> i) {
        ArrayList<banco.Movimentacao> movimentacoes = new ArrayList<banco.Movimentacao>();
        String info = i.next();
        if (info.equals("poo_tp_movimentacoes_database_inicio")) {

            info = i.next();
            while (!info.equals("poo_tp_movimentacoes_database_fim")) {
                int ano = Integer.parseInt(info);
                int mes = Integer.parseInt(i.next());
                int dia = Integer.parseInt(i.next());
                String descricao = i.next();
                char debitoCredito = i.next().charAt(0);
                double valor = Double.parseDouble(i.next());
                movimentacoes.add(new banco.Movimentacao(ano, mes, dia, descricao, debitoCredito, valor));
                info = i.next();
            }
        }
        return movimentacoes;
    }

    private void restauraConta(int numConta,
                              double saldo,
                              ArrayList<banco.Movimentacao> movimentacoes,
                              String cpf_cnpj){
        banco.Cliente c = getCliente(cpf_cnpj);
        if (c == null) return;

		banco.Conta conta = new banco.Conta(numConta, saldo, movimentacoes, c);
		contas.add(conta);
	}
	public int removeCliente(String cpf){
		int flag = 0;
        int contador=0;
        int idCliente=0;
		for(banco.Cliente c : clientes){
			if (c.getCpf_cnpj().equals(cpf)){
				flag=1;
                idCliente=contador;
			}
        contador=contador+1;
		}
		if(flag==0){
			return -1;
		} 
        flag=0;
		for(banco.Conta co : contas ){
            if(co.getCliente().getCpf_cnpj().equals(cpf)){;
            return -2;
            }

        }
        clientes.remove(idCliente);
        return 0;
	}

    public boolean removeConta(int numConta){
        int contador=0;
        for(banco.Conta c : contas){
            if(c.getNumConta() == numConta){
                contas.remove(contador);
                return true;
            }
        contador=contador+1;
        }   
        return false;
    }

    public boolean deposito(int numConta, double valor){
        banco.Conta conta = getConta(numConta);
        if (conta == null) return false;
        return conta.creditar(valor, "Deposito");
    }

    public boolean saque(int numConta, double valor){
        banco.Conta conta = getConta(numConta);
        if (conta == null) return false;
        return conta.debitar(valor, "Saque");
    }

    public ArrayList<banco.Movimentacao> extrato(int numConta){
        banco.Conta conta = getConta(numConta);
        if (conta == null) return null;
        return conta.getExtrato();
    }

    public ArrayList<banco.Movimentacao> extrato(int numConta, GregorianCalendar dataInicial){
        banco.Conta conta = getConta(numConta);
        if (conta == null) return null;
        return conta.getExtrato(dataInicial);
    }

    public ArrayList<banco.Movimentacao> extrato(int numConta, GregorianCalendar dataInicial, GregorianCalendar dataFinal){
        banco.Conta conta = getConta(numConta);
        if (conta == null) return null;
        return conta.getExtrato(dataInicial, dataFinal);
    }

    public void tarifa(){
        for(banco.Conta co : contas ){
            co.debitar(15,"Cobrança de tarifa");
            }
    }

    public double saldo(int numConta){
        for(banco.Conta c : contas){
            if(c.getNumConta() == numConta){
                double saldo = c.getSaldo();
                return saldo;
            }
        }
        return -1;   
    }

    public int transferencia(int numContaOrigem, int numContaDestino, double valor){
            banco.Conta contaOrigem = getConta(numContaOrigem);
            if (contaOrigem == null) return -1;
            banco.Conta contaDestino = getConta(numContaDestino);
            if (contaDestino== null) return -2;

            String st = "Transferencia para conta " + numContaOrigem;
            if(contaOrigem.debitar(valor, st)==false){
                return -3;
            }
            String st2 = "Transferencia da conta " + numContaDestino;
            contaDestino.creditar(valor, st2);
            return 0;




    }
}

