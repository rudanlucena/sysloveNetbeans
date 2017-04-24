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
public class RecomendarAmizade implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String remetente = request.getParameter("remetente");
            String destinatario = request.getParameter("destinatario");
            String recomendacao = request.getParameter("recomendacao");

            GerenciadorRecomendacaoAmizade gra = new GerenciadorRecomendacaoAmizade();
            gra.recomendaAmizade(remetente, destinatario, recomendacao);
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(RecomendarAmizade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
