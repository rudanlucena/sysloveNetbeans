/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.RecomendacaoAmizadeDaoSysLove;
import br.com.syslove.Model.RecomendacaoAmizade;
import br.com.syslove.Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlexaLins
 */
public class RecomendacaoAmizadeDao implements RecomendacaoAmizadeDaoSysLove {

    private final Connection connection;

    public RecomendacaoAmizadeDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean recomenda(RecomendacaoAmizade recomendacao) throws SQLException {
        String sql = "INSERT INTO recomendacoesamizade (remetente, destinatario, recomendacao) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, recomendacao.getRemetente());
        statement.setString(2, recomendacao.getDestinatario());
        statement.setString(3, recomendacao.getRecomendacao());

        return statement.executeUpdate() > 0;
    }

    @Override
    public List<Usuario> lista(String email) throws SQLException {
        String sql = "SELECT * FROM recomendacoesAmizade where destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();

            usuario.setSenha(rs.getString("senha"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setDescricao(rs.getString("descricao"));
            usuario.setStatus(rs.getString("status"));
            usuario.setPeso(rs.getFloat("peso"));
            usuario.setAltura(rs.getFloat("altura"));
            usuario.setCorCabelo(rs.getString("corCabelo"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setSexo(rs.getString("sexo"));

            usuarios.add(usuario);

        }

        return usuarios;
    }

}
