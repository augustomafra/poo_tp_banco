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

import java.util.List;

public class Cliente {
    private String nomeCliente;
    private String cpf_cnpj;
    private String endereco;
    private String fone;

    public Cliente(String nomeCliente, String cpf_cnpj, String endereco, String fone){
    	this.nomeCliente=nomeCliente;
    	this.cpf_cnpj=cpf_cnpj;
    	this.endereco=endereco;
    	this.fone=fone;
    }

    public Cliente(Cliente outro){
    	this.nomeCliente=outro.nomeCliente;
    	this.cpf_cnpj=outro.cpf_cnpj;
    	this.endereco=outro.endereco;
    	this.fone=outro.fone;
    }

    // Preenche a lista data com os dados do cliente
    public void formatarDados(List<String> data) {
        data.add(nomeCliente);
        data.add(cpf_cnpj);
        data.add(endereco);
        data.add(fone);
    }

    public boolean equals(Cliente outro){
        return this.nomeCliente.equals(outro.nomeCliente) &&
               this.cpf_cnpj.equals(outro.cpf_cnpj) &&
               this.endereco.equals(outro.endereco) &&
               this.fone.equals(outro.fone);
    }

    // Para impressao com System.out.println na Interface
    public String toString(){
        String ret = new String();
        ret += "\tNome: " + nomeCliente + "\n";
        ret += "\tCPF/CNPJ: " + cpf_cnpj + "\n";
        ret += "\tEndereco: " + endereco + "\n";
        ret += "\tTelefone: " + fone + "\n";
        ret += "\n";
        return ret;
    }

    public String getNome(){
    	return nomeCliente;

    }

    public String getCpf_cnpj(){
    	return cpf_cnpj;

    }

    public String getEndereco(){
    	return endereco;

    }

    public String getFone(){
    	return fone ;

    }

    public void setNome(String nome){
    	nomeCliente=nome;
    }

    public void setCpf_cnpj(String cpf){
    	cpf_cnpj=cpf;
    }

    public void setEndereco(String end){
    	endereco=end;
    }

    public void setFone(String f){
    	fone=f;
    }

}
