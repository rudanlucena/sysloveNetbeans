package br.com.syslove.Dao;

import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Interface.RelacionamentoDaoSysLove;
import br.com.syslove.Model.Relacionamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlexaLins
 */
public class RelacionamentoDao implements RelacionamentoDaoSysLove {

    private final Connection connection;

    public RelacionamentoDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public boolean novo(Relacionamento relacionamento) throws SQLException {
        String sql = "INSERT INTO relacionamentos (usuario1, usuario2, tipoRelacionamento) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, relacionamento.getUsuario1());
        statement.setString(2, relacionamento.getUsuario2());
        statement.setString(3, relacionamento.getTipo());

        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean atualiza(Relacionamento relacionamento) throws SQLException {
        String sql = "UPDATE relacionamentos SET tipoRelacionamento = ? WHERE usuario1 = ? and usuario2 = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(2, relacionamento.getUsuario1());
        statement.setString(3, relacionamento.getUsuario2());
        statement.setString(1, relacionamento.getTipo());

        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean desfaz(Relacionamento relacionamento) throws SQLException {
        String sql = "DELETE FROM relacionamentos WHERE usuario1 = ? and usuario2 = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, relacionamento.getUsuario1());
        statement.setString(2, relacionamento.getUsuario2());
        
        return statement.executeUpdate() > 0;
    }

    @Override
    public List<Relacionamento> lista() throws SQLException {
        String sql = "SELECT * FROM relacionamentos";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<Relacionamento> relacionamentos = new ArrayList<>();

        while (rs.next()) {
            Relacionamento relacionamento = new Relacionamento();

            relacionamento.setUsuario1(rs.getString(1));
            relacionamento.setUsuario2(rs.getString(2));
            relacionamento.setTipo(rs.getString(3));

            relacionamentos.add(relacionamento);
        }

        return relacionamentos;
    }
    
    @Override
    public boolean verificaAmizade(String usuario, String email) throws SQLException {
        String sql = "SELECT * FROM relacionamentos where (usuario1 = ? and usuario2 = ?) or (usuario1 = ? and usuario2 = ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario);
        statement.setString(2, email);
        statement.setString(3, email);
        statement.setString(4, usuario);
        
        ResultSet rs = statement.executeQuery();

        return rs.next();
    }

}
