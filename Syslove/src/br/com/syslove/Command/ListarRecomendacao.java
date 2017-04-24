package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorRecomendacaoAmizade;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexalins
 */
public class ListarRecomendacao implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            GerenciadorRecomendacaoAmizade gra = new GerenciadorRecomendacaoAmizade();
            gra.listaRecomendaAmizade();
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(ListarRecomendacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
