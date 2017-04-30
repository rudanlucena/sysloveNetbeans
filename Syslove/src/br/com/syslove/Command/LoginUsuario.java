package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alexalins
 */
public class LoginUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();       
        Usuario usuario = null;
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
        
            GerenciadorUsuario gu = new GerenciadorUsuario();
            usuario = gu.localizaUsuario(email, senha);
            
            
            if(usuario != null){
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("senha", senha);
                session.setAttribute("usuario", usuario);                
                response.sendRedirect("inicio.jsp");
            }
        } catch (PersistenciaException | SQLException  ex) {
            out.println(ex.getMessage());
        }
        if(usuario == null)
            response.sendRedirect("index.jsp");
        
        
    }
    
}
