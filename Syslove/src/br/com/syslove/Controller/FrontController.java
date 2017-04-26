package br.com.syslove.Controller;

import javax.servlet.annotation.MultipartConfig;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexalins
 */
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15 // 15 MB
)
public class FrontController extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        
        out.println("action"+action);
        
        try{
            Command command = (Command)Class.forName("br.com.syslove.Command." + action).newInstance();
            command.execute(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            out.println(ex.getMessage());
        }
    }
}
