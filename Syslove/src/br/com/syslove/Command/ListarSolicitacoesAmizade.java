package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class ListarSolicitacoesAmizade implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out =response.getWriter();
        String email = (String) request.getSession().getAttribute("email");
        try {
            GerenciadorSolicitacaoAmizade gs = new GerenciadorSolicitacaoAmizade();
            List<Usuario> usuarios = gs.listaSolicitacaoAmizade(email);
            request.getServletContext().setAttribute("solicitacoes", usuarios);
            
            response.sendRedirect("listarSolicitacoes.jsp");
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
        
    }
    
}