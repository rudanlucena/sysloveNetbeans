package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
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
public class ListarSolicitacaoDeAmizade implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            GerenciadorSolicitacaoAmizade gsa = new GerenciadorSolicitacaoAmizade();
            gsa.listaSolicitacaoAmizade();
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(ListarSolicitacaoDeAmizade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
