package br.com.app;

import br.com.syslove.Dao.SolicitacaoAmizadeDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppSolicitacaoAmizadeDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ConnectionException, ClassNotFoundException {
        //SolicitacaoAmizade sa = new SolicitacaoAmizade("lexa@gmail.com", "rudanlucena@gmail.com");
        //Relacionamento r = new Relacionamento("alexa", "teste", "amigos");
        SolicitacaoAmizadeDao daoSA = new SolicitacaoAmizadeDao();
        System.out.println(daoSA.solicitacaoEnviada("lexa@gmail.com", "rudanlucena@gmail.com"));
        //daoSA.solicita(sa);
        //daoSA.rejeita(sa);
        //daoSA.aceita(r);
        //System.out.println(daoSA.lista("rudanlucena@gmail.com"));
    }
    
}
