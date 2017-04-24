package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.TimeLineDaoSysLove;
import br.com.syslove.Model.FotoGaleria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlexaLins
 */
public class TimeLineDao implements TimeLineDaoSysLove {

    private final Connection connection;

    public TimeLineDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean publica(FotoGaleria imagem) throws SQLException {
        String sql = "INSERT INTO timeline(usuario,imagem,legenda) VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, imagem.getUsuario());
        statement.setString(2, imagem.getImagem());
        statement.setString(3, imagem.getLegenda());
        
        return statement.executeUpdate() > 0;
    }
}
