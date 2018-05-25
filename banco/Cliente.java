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

 class Cliente {
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
