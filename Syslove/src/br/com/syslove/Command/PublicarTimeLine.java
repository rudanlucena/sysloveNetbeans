package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorTimeLine;
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
public class PublicarTimeLine implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String foto = request.getParameter("foto");
            String usuario = request.getParameter("usuario");
            String legenda = request.getParameter("legenda");

            GerenciadorTimeLine gt = new GerenciadorTimeLine();
            gt.persisteTimeLine(usuario, foto, legenda);
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(PublicarTimeLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
