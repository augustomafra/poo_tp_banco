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

    public banco.Conta criaConta(banco.Cliente cliente){
		int flag = 0;
		for (banco.Cliente c : clientes){
			if( c.equals(cliente) ){
			flag=1;
			}
		}
		if(flag==0){
			return null;
		}
		banco.Conta conta = new banco.Conta(cliente);
		contas.add(conta);
        banco.Conta copia = new banco.Conta(conta);
        return copia;
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

