package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexalins
 */
public class AtualizarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        try {
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

            GerenciadorUsuario gu = new GerenciadorUsuario();
            gu.atualizaUsuario(email, senha, nome, apelido, dataNascimento, cidade, profissao, descricao, status, 0, 0, corCabelo, fotoperfil, sexo, passaTempo);
            
        } catch (PersistenciaException ex) {
            out.println("Erro não foi possivel instanciar o GerenciadorUsuario");
        } catch (SQLException ex) {
            out.println("Erro não foi possivel cadastrar o usuario" + ex.getMessage());
        }

        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement().toString();
            String value = request.getParameter(parameterName);
            out.println(value);
        }

    }

}
