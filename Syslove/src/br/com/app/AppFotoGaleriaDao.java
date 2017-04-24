package br.com.app;

import br.com.syslove.Dao.FotoGaleriaDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.FotoGaleria;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppFotoGaleriaDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        FotoGaleria fg = new FotoGaleria("teste", "img.jpg", "topper");
        FotoGaleriaDao daoFg = new FotoGaleriaDao();
        
        //daoFg.persiste(fg);
        //System.out.println(daoFg.lista());
        //daoFg.exclui(fg);
    }
    
}
