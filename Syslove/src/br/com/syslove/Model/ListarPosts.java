package br.com.syslove.Model;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorTimeLine;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.PageContext.PAGE_SCOPE;
import static javax.servlet.jsp.PageContext.SESSION_SCOPE;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.xml.ws.Response;


public class ListarPosts extends SimpleTagSupport{
        
    @Override
    public void doTag() throws JspException, IOException{
        String email = (String) getJspContext().getAttribute("email", SESSION_SCOPE);
        JspWriter out = getJspContext().getOut();
        
        try {
            GerenciadorTimeLine GTL = new GerenciadorTimeLine();
            List<TimeLine> posts = GTL.lista(email);
            getJspContext().setAttribute("posts", posts, PAGE_SCOPE);
            
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        } 
    }
}
