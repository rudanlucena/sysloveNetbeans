package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SolicitarAmizade implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            String remetente = (String) request.getSession().getAttribute("email");
            String destinatario = request.getParameter("destinatario");
            
            GerenciadorSolicitacaoAmizade gsa = new GerenciadorSolicitacaoAmizade();
            gsa.solicitaAmizade(remetente, destinatario);
            
            GerenciadorUsuario GU = new GerenciadorUsuario();
            Usuario usuario = GU.busca(destinatario);
            
            request.setAttribute("usuario", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
        

    }

}
