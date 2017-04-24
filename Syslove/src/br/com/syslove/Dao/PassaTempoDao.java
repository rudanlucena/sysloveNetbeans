/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.PassaTempoDaoSysLove;
import br.com.syslove.Model.PassaTempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlexaLins
 */
public class PassaTempoDao implements PassaTempoDaoSysLove {

    private final Connection connection;

    public PassaTempoDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean persiste(PassaTempo passaTempo) throws SQLException {
        String sql = "INSERT INTO passatempos(usuario, passatempo)  VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, passaTempo.getUsuario());
        statement.setString(2, passaTempo.getPassatempo());

        return statement.executeUpdate() > 0;
    }

}
