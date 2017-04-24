package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorFotoGaleria;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AdicionarFoto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        try {
            String usuario = request.getParameter("usuario");
            String foto = request.getParameter("foto");
            String legenda = request.getParameter("legenda");

            GerenciadorFotoGaleria gf = new GerenciadorFotoGaleria();
            gf.persisteFotoGaleria(usuario, foto, legenda);
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel cadastrar o usuario" + ex.getMessage());
        }

    }

}
