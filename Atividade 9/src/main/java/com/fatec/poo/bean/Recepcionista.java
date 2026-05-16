package com.fatec.poo.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Recepcionista extends Funcionario {
    private String cpf;

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (cpf == null || cpf.isBlank()) {
            throw new Exception("Ocorreu um erro. O CPF não pode ser vazio!"); [cite: 12]
        }
        
        String cpfLimpo = cpf.replace(".", "").replace("-", "");
        
        if (cpfLimpo.length() != 11) {
            throw new Exception("Ocorreu um erro. O CPF digitado deve ter 11 dígitos!"); [cite: 12]
        }
        
        this.cpf = cpfLimpo;
    }

    public Recepcionista(){
        super(); [cite: 12]
        this.cpf = "";
    }

    public Recepcionista(String pNome, String pCpf, String pTelefone, String pSenha) throws Exception {
        setNome(pNome); [cite: 12]
        setCpf(pCpf); [cite: 12]
        setTelefone(pTelefone); [cite: 12]
        setSenha(pSenha); [cite: 12]
    }

    public void mostrar(){
        System.out.println("----Recepcionista---");
        System.out.println("Nome: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone() + "\nSenha: " + getSenha() + "\n"); [cite: 12]
    }

    @Override
    public void acessar() {
        System.out.println("Acesso ao sistema de agendamento liberado para a recepção: " + getNome()); [cite: 12]
    }

    public Agenda marcarAgenda(Paciente p, Medico m, LocalTime hora, LocalDate data) throws Exception {
        var a1 = new Agenda();
        a1.setData(data);
        a1.setHora(hora);
        a1.setMedico(m);
        a1.setPaciente(p);
        return a1;
    }
}