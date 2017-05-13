/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.SolicitacaoAmizadeDaoSysLove;
import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
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
public class SolicitacaoAmizadeDao implements SolicitacaoAmizadeDaoSysLove {

    private final Connection connection;

    public SolicitacaoAmizadeDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean solicita(SolicitacaoAmizade solicitacao) throws SQLException {
        String sql = "INSERT INTO solicitacoesamizade (remetente, destinatario) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, solicitacao.getRemetente());
        statement.setString(2, solicitacao.getDestinatario());

        return statement.executeUpdate() > 0;

    }

    @Override
    public boolean exclui(SolicitacaoAmizade solicitacao) throws SQLException {
        String sql = "DELETE FROM solicitacoesamizade WHERE remetente = ? and destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, solicitacao.getRemetente());
        statement.setString(2, solicitacao.getDestinatario());

        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean aceita(SolicitacaoAmizade solicitacao) throws SQLException {
        String sql = "INSERT INTO relacionamentos (usuario1, usuario2, tipoRelacionamento) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, solicitacao.getRemetente());
        statement.setString(2, solicitacao.getDestinatario());
        statement.setString(3, "amigos");
                        
        exclui(solicitacao);

        return statement.executeUpdate() > 0;
    }

    @Override
    public List<Usuario> lista(String email) throws SQLException{
        String sql = "SELECT * FROM usuarios u, solicitacoesamizade s where s.destinatario = ? and s.remetente = u.email ";
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
    
    @Override
    public boolean solicitacaoEnviada(String usuario, String email) throws SQLException {
        String sql = "SELECT * FROM solicitacoesAmizade where remetente = ? and destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario);
        statement.setString(2, email);
        
        ResultSet rs = statement.executeQuery();

        return rs.next();
    }

    @Override
    public boolean solicitacaoRecebida(String usuario, String email) throws SQLException {
        String sql = "SELECT * FROM solicitacoesAmizade where remetente = ? and destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, email);
        statement.setString(2, usuario);
        
        ResultSet rs = statement.executeQuery();

        return rs.next();
    }

}
