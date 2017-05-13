package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import java.io.File;
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
public class ExcluirUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        File dir = new File( request.getServletContext().getRealPath("img/"+email));
        
        try {
            GerenciadorUsuario gu = new GerenciadorUsuario();
            gu.excluiUsuario(email);
            session.invalidate();
            
            boolean deleteDir = deleteDir(dir);
            response.sendRedirect("index.jsp");
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel cadastrar o usuario" + ex.getMessage());
        }
    }
    
    public boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) { 
               boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
