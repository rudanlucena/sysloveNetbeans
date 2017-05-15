package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;

/**
 *
 * @author alexalins
 */
public class ListarUsuarios implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String sexo = request.getParameter("sexo");
     
        try {
            GerenciadorUsuario gu = new GerenciadorUsuario();
            request.setAttribute("usuarios", gu.listaUsuario(nome, cidade, sexo));
            request.setAttribute("searchNome", nome);
            request.setAttribute("searchCidade", cidade);
            request.setAttribute("searchSexo", sexo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios.jsp");
            dispatcher.forward(request, response);
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel listar os usuarios" + ex.getMessage());
        }
        
        
    }
    
}
