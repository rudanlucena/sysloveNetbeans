package br.com.syslove.Command;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Interface.Command;
import br.com.syslove.Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
        Usuario usuarioOLD = (Usuario) request.getSession().getAttribute("usuario");
        String fotoPerfil = usuarioOLD.getFotoPerfil();
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
            String sexo = request.getParameter("sexo");
            String passaTempo = request.getParameter("passaTempo");

            GerenciadorUsuario gu = new GerenciadorUsuario();
            Usuario usuario = gu.atualizaUsuario(email, senha, nome, apelido, dataNascimento, cidade, profissao, descricao, status, peso, altura, corCabelo, sexo, passaTempo, identificacao, fotoPerfil);
            if(usuario!=null){
                session.setAttribute("email", email);
                session.setAttribute("senha", senha);
                session.setAttribute("usuario", usuario);
            }
        }catch (PersistenciaException | SQLException ex) {
            out.println(ex.getMessage());
        }
                
        response.sendRedirect("inicio.jsp");

    }

}
