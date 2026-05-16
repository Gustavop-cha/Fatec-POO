package com.fatec.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fatec.poo.BD.ConexaoSQL;
import com.fatec.poo.bean.Recepcionista;


public class RecepcionistaDAO {
    public void inserir(Recepcionista rec) throws Exception {
        String sql = "INSERT INTO recepcionista (nome, cpf, telefone, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoSQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rec.getNome());
            stmt.setString(2, rec.getCpf());
            stmt.setString(3, rec.getTelefone());
            stmt.setString(4, rec.getSenha());
            stmt.executeUpdate();
        }
    }
}