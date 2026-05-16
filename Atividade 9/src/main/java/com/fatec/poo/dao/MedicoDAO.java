package com.fatec.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fatec.poo.BD.ConexaoSQL;
import com.fatec.poo.bean.Medico;

public class MedicoDAO {
    public void inserir(Medico medico) throws Exception {
        String sql = "INSERT INTO medico (nome, crm, telefone, especialidade, senha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoSQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getTelefone());
            stmt.setString(4, medico.getEspecialidade());
            stmt.setString(5, medico.getSenha());
            stmt.executeUpdate();
        }
    }

    public List<Medico> listar() throws Exception {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico";
        try (Connection conn = ConexaoSQL.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Medico(rs.getString("nome"), rs.getString("crm"), 
                          rs.getString("telefone"), rs.getString("especialidade"), rs.getString("senha")));
            }
        }
        return lista;
    }
}