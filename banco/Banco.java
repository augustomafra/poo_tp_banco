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

    public boolean addCliente(banco.Cliente cliente){
        return clientes.add(cliente); // true se adicao foi bem sucedida
    }

    // FIXME: Toda operacao de ler/escrever no console deve ser feita na classe
    // Interface. Funcoes do Banco podem retornar um boolean, que a Interface
    // pode checar para decidir se a operacao deu erro ou nao.
    public void criaConta(banco.Cliente cliente){
		int flag = 0;
		for (banco.Cliente c : clientes){
			if( c.equals(cliente) ){
			flag=1;
			}
		}
		if(flag==0){
			System.out.println("ERRO: Cliente não cadastrado no banco");
			return;
		}
		banco.Conta conta = new banco.Conta(cliente);
		contas.add(conta);
	}
   /*
	public void removeCliente(string cpf){
		int flag = 0;
		for(banco.Cliente c : clientes){
			if (c.getCpf_cnpj().equals(cpf)){
				flag=1;
			}
		}
		if(flag==0){
			System.out.println("ERRO: Cliente não cadastrado no banco");
			return;
		}

		for(banco.Conta)
	}
	*/
}

