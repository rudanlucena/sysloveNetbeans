/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Model;


import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorRelacionamento;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.PageContext.PAGE_SCOPE;
import static javax.servlet.jsp.PageContext.SESSION_SCOPE;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 *
 * @author rudan
 */
public class VerificaRelacionamento extends SimpleTagSupport{
    
    String email;
    
    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    
    public void doTag() throws JspException, IOException{
       String usuario = (String) getJspContext().getAttribute("email", SESSION_SCOPE);
       JspWriter out = getJspContext().getOut();
       
        try {
            GerenciadorSolicitacaoAmizade gsa = new GerenciadorSolicitacaoAmizade();
            
            GerenciadorRelacionamento gr= new GerenciadorRelacionamento();
            if(gsa.solicitacaoEnviada(usuario, email)){
                getJspContext().setAttribute("relacao", "solicitacaoEnviada", PAGE_SCOPE);
            }
            else if(gsa.solicitacaoRecebida(usuario, email)){
                getJspContext().setAttribute("relacao", "solicitacaoRecebida", PAGE_SCOPE);
            }
            else if(gr.verificaAmizade(usuario, email)){
                getJspContext().setAttribute("relacao", "amigos", PAGE_SCOPE);
            }
            else{
                getJspContext().setAttribute("relacao", "nenhuma", PAGE_SCOPE);
            }
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
    }
    

}
