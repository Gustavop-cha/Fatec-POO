package com.fatec.poo;


import com.fatec.poo.bean.Medico;
import com.fatec.poo.bean.Recepcionista;
import com.fatec.poo.dao.MedicoDAO;
import com.fatec.poo.dao.RecepcionistaDAO;
public class Main {
    public static void main(String[] args) {
        try {
            MedicoDAO mdao = new MedicoDAO();
            System.out.println("Conectado ao MedicoDAO!");

            Medico m1 = new Medico();
            m1.setNome("Dr. Chá");
            m1.setCrm("12345SP");
            m1.setTelefone("11-98888-7777");
            m1.setEspecialidade("Neuro");
            m1.setSenha("med123");

            mdao.inserir(m1);
            System.out.println("Médico inserido com sucesso!");

            RecepcionistaDAO rdao = new RecepcionistaDAO();
            System.out.println("Conectado ao RecepcionistaDAO!");

            Recepcionista r1 = new Recepcionista();
            r1.setNome("Rafaela");
            r1.setCpf("12345678901"); 
            r1.setTelefone("11-4002-8922");
            r1.setSenha("rec123");

            rdao.inserir(r1);
            System.out.println("Recepcionista inserida com sucesso!");

            System.out.println("\n--- Lista de Médicos ---");
            for (Medico m : mdao.listar()) {
                System.out.println(m.getCrm() + " - " + m.getNome() + " (" + m.getEspecialidade() + ")");
            }

        } catch (Exception err) {
            System.out.println("Ocorreu um erro: " + err.getMessage());
            err.printStackTrace(); 
        }
    }
}