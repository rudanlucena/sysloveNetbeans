/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.MensagemDaoSysLove;
import br.com.syslove.Model.Mensagem;
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
public class MensagemDao implements MensagemDaoSysLove {

    private final Connection connection;

    public MensagemDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean envia(Mensagem mensagem) throws SQLException {
        String sql = "INSERT INTO mensagens (remetente, destinatario, mensagem) VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, mensagem.getRemetente());
        statement.setString(2, mensagem.getDestinatario());
        statement.setString(3, mensagem.getMensagem());

        return statement.executeUpdate() > 0;
    }

    @Override
    public List<Usuario> listarNovas(String email) throws SQLException {
        String sql = "SELECT * from mensagens m, usuarios u where m.remetente = u.email and m.destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        List<Usuario> usuarios = new ArrayList<>();
        
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
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
