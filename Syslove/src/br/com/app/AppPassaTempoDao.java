package br.com.app;

import br.com.syslove.Dao.PassaTempoDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.PassaTempo;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppPassaTempoDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        PassaTempo ps = new PassaTempo("alexa", "joga LoL");
        PassaTempoDao daoPs = new PassaTempoDao();
        
        daoPs.persiste(ps);
        
    }
    
}
