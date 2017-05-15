/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Model;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorRecomendacaoAmizade;
import br.com.syslove.Gerenciador.GerenciadorSolicitacaoAmizade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.PageContext.PAGE_SCOPE;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author rudan
 */
public class ListarRecomendacoes extends SimpleTagSupport{
    private String email;
    @Override
    public void doTag() throws JspException, IOException{
        JspWriter out = getJspContext().getOut();
        
        try {
            GerenciadorRecomendacaoAmizade GRA = new GerenciadorRecomendacaoAmizade();
            List<Usuario> usuarios = GRA.listaRecomendaAmizade(email);
                      
            getJspContext().setAttribute("solicitacoes", usuarios, PAGE_SCOPE);
        } catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        } 
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

