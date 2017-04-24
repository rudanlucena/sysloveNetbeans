package br.com.syslove.Servlet;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersisteUsuario extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
                    
        //dados da tabela usuario
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
        String fotoperfil = request.getParameter("fotoPerfil");
        String sexo = request.getParameter("sexo");
        String passaTempo = request.getParameter("passaTempo");
                
        GerenciadorUsuario gu = null;
        try {
            gu = new GerenciadorUsuario();
            gu.persisteUsuario(email, senha, nome, apelido, dataNascimento, cidade, profissao, descricao, status, peso, altura, corCabelo, fotoperfil, sexo, passaTempo);
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
            
        } catch (SQLException ex) {
            out.println("Erro não foi possivel cadastrar o usuario"+ex.getMessage());
        }
                                
        Enumeration parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement().toString();
            String value = request.getParameter(parameterName);
            out.println(value);
        }
            
        
    }
    
}
