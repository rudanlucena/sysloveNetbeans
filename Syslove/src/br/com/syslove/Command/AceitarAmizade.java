package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexalins
 */
public class AceitarAmizade implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String destinatario = (String) request.getSession().getAttribute("email");
            String remetente = request.getParameter("remetente");
            
            GerenciadorSolicitacaoAmizade gsa = new GerenciadorSolicitacaoAmizade();
            gsa.aceitaSolicitacaoAmizade(remetente, destinatario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listarSolicitacoes.jsp");
            dispatcher.forward(request, response);
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(AceitarAmizade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
