package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorTimeLine;
import br.com.syslove.Interface.Command;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author alexalins
 */
public class AdicionarFoto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        Part part = request.getPart("imagem");

        try {
            String email = (String) request.getSession().getAttribute("email");
            String imagem = getFileName(part);
            String legenda = request.getParameter("legenda");

            GerenciadorTimeLine gtl = new GerenciadorTimeLine();
            gtl.persisteTimeLine(email, imagem, legenda);
            
            File dir = new File( request.getServletContext().getRealPath("img/"+email) );// diretório de upload
         
            //se o diretório não existe ele cria
            if( !dir.isDirectory() ){
                dir.mkdir();
            }

            
          
            if(imagem != null){
                File arquivo = new File( dir.getAbsolutePath() + "/" + imagem ); 
                part.write( arquivo.getAbsolutePath());
            }
            response.sendRedirect("inicio.jsp");
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel postar a foto o usuario" + ex.getMessage());
        }

    }
    
    public String getFileName(Part part){
        String header = part.getHeader( "content-disposition" );
        for( String tmp : header.split(";") ){
            if( tmp.trim().startsWith("filename") ){
                return tmp.substring( tmp.indexOf("=")+2 , tmp.length()-1 );   
            }
        }
        return null;
    }

}
