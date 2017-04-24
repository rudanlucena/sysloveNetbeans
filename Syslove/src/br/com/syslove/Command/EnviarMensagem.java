package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorMensagem;
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
public class EnviarMensagem implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String rementente = request.getParameter("remetente");
            String destinatario = request.getParameter("destinatario");
            String mensagem = request.getParameter("mensagem");

            GerenciadorMensagem gm = new GerenciadorMensagem();
            gm.enviaMensagem(rementente, destinatario, mensagem);
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(EnviarMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
