package br.com.app;

import br.com.syslove.Dao.RecomendacaoAmizadeDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.RecomendacaoAmizade;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppRecomendacaoAmizadeDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        RecomendacaoAmizade ra = new RecomendacaoAmizade("alexa", "teste", "rudan");
        RecomendacaoAmizadeDao daoRA = new RecomendacaoAmizadeDao();
        
        daoRA.recomenda(ra);
        System.out.println(daoRA.lista());
    }
    
}
