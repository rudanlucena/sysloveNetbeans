package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorRelacionamento;
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
public class NovoRelacionamento implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String usuario1 = request.getParameter("usuario1");
            String usuario2 = request.getParameter("usuario2");
            String tipo = request.getParameter("tipo");

            GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
            gr.persisteRelacionamento(usuario1, usuario2, tipo);
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(NovoRelacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
