package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.TimeLineDaoSysLove;
import br.com.syslove.Model.TimeLine;
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
public class TimeLineDao implements TimeLineDaoSysLove {

    private final Connection connection;

    public TimeLineDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean publica(TimeLine post) throws SQLException {
        String sql = "INSERT INTO timeline(usuario,imagem,legenda) VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, post.getUsuario());
        statement.setString(2, post.getImagem());
        statement.setString(3, post.getLegenda());
        
        return statement.executeUpdate() > 0;
    }
    
    @Override
    public List<TimeLine> lista(String email) throws SQLException{
        String sql = "select U.nome, u.email, TL.imagem, TL.legenda FROM timeLine TL, usuarios U WHERE (U.email = TL.usuario) AND TL.usuario=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        //statement.setString(2, email);
               
        ResultSet rs = statement.executeQuery();
        List<TimeLine> posts = new ArrayList<>();
        
        while(rs.next()){
            TimeLine post = new TimeLine();
            post.setUsuario(rs.getString("nome"));
            post.setEmail(rs.getString("email"));
            post.setImagem(rs.getString("imagem"));
            post.setLegenda(rs.getString("legenda"));
            
            posts.add(post);
        }
        
        return posts;
        
    }
}
