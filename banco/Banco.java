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
        System.out.println("Restaurando informacoes do banco " + nomeBanco + " do arquivo " + filePath);
    }

    public boolean salvar(Path filePath)
    {
        System.out.println("Salvando informacoes do banco " + nomeBanco + " no arquivo " + filePath);
        List<String> data = Arrays.asList("Inicio do arquivo", "Fim do arquivo");
        try {
            Files.write(filePath, data, Charset.forName("UTF-8"));
        } catch(IOException e) {
            return false;
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
}

