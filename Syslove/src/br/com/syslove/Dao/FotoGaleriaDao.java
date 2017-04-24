package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Model.FotoGaleria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.syslove.Interface.GaleriaDaoSysLove;

/**
 *
 * @author AlexaLins
 */
public class FotoGaleriaDao implements GaleriaDaoSysLove {

    private final Connection connection;

    public FotoGaleriaDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean persiste(FotoGaleria fotoUsuario) throws SQLException {
        String sql = "INSERT INTO galeriafotos(usuario,imagem,legenda) VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, fotoUsuario.getUsuario());
        statement.setString(2, fotoUsuario.getImagem());
        statement.setString(3, fotoUsuario.getLegenda());

        return statement.executeUpdate() > 0;

    }

    @Override
    public boolean exclui(FotoGaleria fotoUsuario) throws SQLException {
        String sql = "DELETE FROM galeriafotos WHERE usuario = ? and imagem = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, fotoUsuario.getUsuario());
        statement.setString(2, fotoUsuario.getImagem());

        return statement.executeUpdate() > 0;

    }

    @Override
    public List<FotoGaleria> lista() throws SQLException {
        String sql = "SELECT * FROM galeriafotos";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<FotoGaleria> fotos = new ArrayList<>();

        while (rs.next()) {
            FotoGaleria foto = new FotoGaleria();
            foto.setUsuario(rs.getString(1));
            foto.setImagem(rs.getString(2));
            foto.setLegenda(rs.getString(3));
            fotos.add(foto);
        }

        return fotos;
    }

}
