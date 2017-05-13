package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorRelacionamento;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
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
 * @author rudan
 */
public class CadastrarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            Part part = request.getPart("fotoPerfil");
            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");
            String apelido = request.getParameter("apelido");
            String dataNascimento = request.getParameter("dataNascimento");
            String cidade = request.getParameter("cidade");
            String profissao = request.getParameter("profissao");
            String descricao = request.getParameter("descricao");
            String status = request.getParameter("status");
            double peso = Double.parseDouble(request.getParameter("peso"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            String corCabelo = request.getParameter("corCabelo");
            String fotoperfil = "perfil"+getFileName(part);
            String sexo = request.getParameter("sexo");
            String passaTempo = request.getParameter("passaTempo");
            
            GerenciadorUsuario gu = new GerenciadorUsuario();
            gu.persisteUsuario(email, senha, nome, apelido, dataNascimento, cidade, profissao, descricao, status, peso, altura, corCabelo, fotoperfil, sexo, passaTempo);
            
            GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
            gr.persisteRelacionamento(email, email, "você");
            
            File dir = new File( request.getServletContext().getRealPath("img/"+email) );// diretório de upload
         
            //se o diretório não existe ele cria
            if( !dir.isDirectory() ){
                dir.mkdir();
            }

            String ext = getFileName(part);
            out.println(ext);
            if(ext != null){
                File arquivo = new File( dir.getAbsolutePath() + "/perfil" + ext ); 
                part.write( arquivo.getAbsolutePath());
            }
                   
            
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel cadastrar o usuario" + ex.getMessage());
        }
        response.sendRedirect("welcome.jsp");      
    }
    
    
    public String getFileName(Part part){
        String header = part.getHeader( "content-disposition" );
        for( String tmp : header.split(";") ){
            if( tmp.trim().startsWith("filename") ){
                String nome = tmp.substring( tmp.indexOf("=")+2 , tmp.length()-1 );
                String ext = nome.substring(nome.length()-4, nome.length());
                return ext;
            }
        }
        return null;
    }

}
