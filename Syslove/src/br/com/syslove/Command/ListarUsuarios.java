package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;

/**
 *
 * @author alexalins
 */
public class ListarUsuarios implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String email = (String) request.getSession().getAttribute("email");
        String nome = request.getParameter("nome");
        try {
            GerenciadorUsuario gu = new GerenciadorUsuario();
            request.getServletContext().setAttribute("usuarios", gu.listaUsuario(email, nome));
            
            response.sendRedirect("listarUsuarios.jsp");
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel listar os usuarios" + ex.getMessage());
        }
        
        
    }
    
}
