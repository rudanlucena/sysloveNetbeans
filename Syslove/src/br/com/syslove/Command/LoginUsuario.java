package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
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
public class LoginUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
        
            GerenciadorUsuario gu = new GerenciadorUsuario();
            
            if(gu.localizaUsuario(email, senha)){
                response.sendRedirect("inicio.html");
            }
            else{
                response.sendRedirect("index.html");
            }
        } catch (PersistenciaException | SQLException  ex) {
            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
