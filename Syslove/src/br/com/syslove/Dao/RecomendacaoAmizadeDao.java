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
    public List<RecomendacaoAmizade> lista() throws SQLException {
        String sql = "SELECT * FROM recomendacoesAmizade";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<RecomendacaoAmizade> recomendacoes = new ArrayList<>();

        while (rs.next()) {
            RecomendacaoAmizade recomendacao = new RecomendacaoAmizade();

            recomendacao.setRemetente(rs.getString(1));
            recomendacao.setDestinatario(rs.getString(2));
            recomendacao.setDestinatario(rs.getString(3));

            recomendacoes.add(recomendacao);

        }

        return recomendacoes;
    }

}
