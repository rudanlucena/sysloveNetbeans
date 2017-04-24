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
    public boolean rejeita(SolicitacaoAmizade solicitacao) throws SQLException {
        String sql = "DELETE FROM solicitacoesamizade WHERE remetente = ? and destinatario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, solicitacao.getRemetente());
        statement.setString(2, solicitacao.getDestinatario());

        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean aceita(Relacionamento relacionamento) throws SQLException {
        String sql = "INSERT INTO relacionamentos (usuario1, usuario2, tipoRelacionamento) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, relacionamento.getUsuario1());
        statement.setString(2, relacionamento.getUsuario2());
        statement.setString(3, relacionamento.getTipo());

        return statement.executeUpdate() > 0;
    }

    @Override
    public List<SolicitacaoAmizade> lista() throws SQLException {
        String sql = "SELECT * FROM solicitacoesamizade";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<SolicitacaoAmizade> solicitacoes = new ArrayList<>();

        while (rs.next()) {
            SolicitacaoAmizade solicitacao = new SolicitacaoAmizade();

            solicitacao.setRemetente(rs.getString(1));
            solicitacao.setDestinatario(rs.getString(2));

            solicitacoes.add(solicitacao);
        }

        return solicitacoes;
    }
}
