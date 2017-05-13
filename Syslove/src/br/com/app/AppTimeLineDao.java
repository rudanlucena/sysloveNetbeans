package br.com.app;

import br.com.syslove.Dao.TimeLineDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.FotoGaleria;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppTimeLineDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        FotoGaleria ft = new FotoGaleria("alexa", "imagem.jpg", "topper");
        TimeLineDao DaoTl = new TimeLineDao();
        
        System.out.println(DaoTl.lista("alexa@gmail.com"));
        
        //DaoTl.publica(ft);
    }
    
}
