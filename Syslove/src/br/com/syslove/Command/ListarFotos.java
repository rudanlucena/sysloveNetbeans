/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorTimeLine;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.TimeLine;
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

public class ListarFotos implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        
        try {
            GerenciadorTimeLine GTL = new GerenciadorTimeLine();
            List<TimeLine> posts = GTL.lista(email);
            request.setAttribute("posts", posts);
            request.setAttribute("email",email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarFotos.jsp");
            dispatcher.forward(request, response);
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
        
    }
    
}
