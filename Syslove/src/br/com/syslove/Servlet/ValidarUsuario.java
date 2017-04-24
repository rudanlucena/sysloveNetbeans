/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Servlet;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class ValidarUsuario extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        PrintWriter out = response.getWriter();
        
        GerenciadorUsuario gu = null;
        
        try {
            gu = new GerenciadorUsuario();
            RequestDispatcher dispatcher;
            if(gu.localizaUsuario(email, senha)){
                response.sendRedirect("inicio.html");
            }
            else{
                response.sendRedirect("index.html");
            }
        } catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(ValidarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    } 
    
}
