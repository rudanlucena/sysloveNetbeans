package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alexalins
 */
public class AtualizarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String identificacao = (String) request.getSession().getAttribute("email");
        HttpSession session = request.getSession();
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
            String fotoPerfil = request.getParameter("fotoPerfil");
            String sexo = request.getParameter("sexo");
            String passaTempo = request.getParameter("passaTempo");

            GerenciadorUsuario gu = new GerenciadorUsuario();
            Usuario usuario = gu.atualizaUsuario(email, senha, nome, apelido, dataNascimento, cidade, profissao, descricao, status, peso, altura, corCabelo, fotoPerfil, sexo, passaTempo, identificacao);
            if(usuario!=null){
                session.setAttribute("email", email);
                session.setAttribute("senha", senha);
                session.setAttribute("usuario", usuario);
            }
        }catch (PersistenciaException | SQLException ex) {
            Logger.getLogger(AtualizarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        response.sendRedirect("inicio.html");

    }

}
