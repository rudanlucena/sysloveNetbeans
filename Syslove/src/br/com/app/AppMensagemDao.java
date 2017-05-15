package br.com.app;

import br.com.syslove.Dao.MensagemDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.Mensagem;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppMensagemDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        Mensagem m = new Mensagem("rudan@gmail.com", "alexa@gmail.com", "oi");
        MensagemDao daoM = new MensagemDao();
        
        //daoM.envia(m);
        System.out.println(daoM.listarNovas("alexa@gmail.com"));
    }
    
}
