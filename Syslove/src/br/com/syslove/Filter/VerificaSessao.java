/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rudan
 */
public class VerificaSessao implements Filter{
    private FilterConfig config;
    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.config = fc;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String email = (String) httpRequest.getSession().getAttribute("email");
        String senha = (String) httpRequest.getSession().getAttribute("senha");
        
        if(!(email == null && senha == null)){
            httpResponse.sendRedirect("inicio.jsp");
        }
        fc.doFilter(request, response);
    }

    @Override
    public void destroy() {
        config = null;
    }
    
}
