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
import java.sql.SQLException;
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
}
