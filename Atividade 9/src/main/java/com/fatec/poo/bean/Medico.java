package com.fatec.poo.bean;

public class Medico extends Funcionario {
    
    private String crm;
    private String especialidade; 

    public String getCrm(){
        return crm;
    }

    public void setCrm(String crm) throws Exception{
        if(crm == null || crm.isBlank()){
            throw new Exception("Ocorreu um erro."); [cite: 8]
        }
        else {
            this.crm = crm;
        }
    }  

    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }   

    public Medico(){
        super(); [cite: 8]
        this.crm = "";
        this.especialidade = "";
    }

    public Medico(String pNome, String pCrm, String pTelefone, String pEspecialidade, String pSenha) throws Exception {
        setNome(pNome); [cite: 8]
        setCrm(pCrm); [cite: 8]
        setTelefone(pTelefone); [cite: 8]
        setEspecialidade(pEspecialidade); [cite: 8]
        setSenha(pSenha); [cite: 8]
    }

    public void mostrar(){
        System.out.println("---Médico---");
        System.out.println("Nome: " + getNome() + "\ncrm: " + getCrm() + "\ntelefone: " + getTelefone() + "\nespecialidade: " + getEspecialidade() + "\nsenha: " + getSenha() + "\n"); [cite: 8]
    }

    @Override
    public void acessar() {
        System.out.println("Acesso ao prontuário médico liberado para o Dr(a). " + getNome()); [cite: 8]
    }
}