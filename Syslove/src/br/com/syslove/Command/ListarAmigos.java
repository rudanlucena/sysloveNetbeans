/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
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
 * @author rudan
 */
public class ListarAmigos implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String email = (String) request.getSession().getAttribute("email");
        String searchNome = (String) request.getParameter("nome");
        out.println(searchNome);
        
        try {
            GerenciadorUsuario gu = new GerenciadorUsuario();
            List<Usuario> usuarios = gu.listaAmigos(email, searchNome);
            request.setAttribute("amigos", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarAmigos.jsp");
            dispatcher.forward(request, response);
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
    }
    
}
