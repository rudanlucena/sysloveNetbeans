/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author rudan
 */
public class AtualizarFotoPerfil implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = (String) request.getSession().getAttribute("email");
        Part part = request.getPart("fotoPerfil");
        String imagem = "perfil"+getFileName(part);
        
        try {
            GerenciadorUsuario GU = new GerenciadorUsuario();
            GU.atualizaFotoPerfil(email, imagem);
            
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
            
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(AtualizarFotoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
