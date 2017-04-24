/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.syslove.Dao.RelacionamentoDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Model.Relacionamento;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppRelacionamentoDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException {
        Relacionamento r = new Relacionamento("alexa", "rudan", "amigos");
        RelacionamentoDao daoR = new RelacionamentoDao();
        
        daoR.novo(r);
        //daoR.atualiza(r);
        //System.out.println(daoR.lista());
        //daoR.desfaz(r);
    }
    
}
