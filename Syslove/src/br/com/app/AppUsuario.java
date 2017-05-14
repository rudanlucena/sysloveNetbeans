package br.com.app;

import br.com.syslove.Dao.TimeLineDao;
import br.com.syslove.Dao.UsuarioDao;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Gerenciador.GerenciadorUsuario;
import br.com.syslove.Model.FotoGaleria;
import br.com.syslove.Model.TimeLine;
import br.com.syslove.Model.Usuario;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public class AppUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnectionException, ClassNotFoundException, SQLException, PersistenciaException {
       
       GerenciadorUsuario gu = new GerenciadorUsuario();
        
       //gu.persisteUsuario("rudan@gmail.com", "hvlk", "rudan", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("tigi@gmail.com", "hvlk", "tigi", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("natan@gmail.com", "hvlk", "natan", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("juan@gmail.com", "hvlk", "juan", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("ricarte@gmail.com", "hvlk", "ricarte", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail1.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail2.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail3.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail4.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail5.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.persisteUsuario("alexagmail6.com", "hvlk", "alexa", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo");
       //gu.atualizaUsuario("emailNovo6", "senha", "nome", "apelido", "data", "cidade", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo", "passaTempo", "emailNovo");
       //System.out.println(daoU.localiza(u));
       //daoU.atualiza(u);
       //System.out.println(gu.listaAmigos("rudan@gmail.com", ""));
       //System.out.println(gu.busca("zxczx"));
       //daoU.exclui(u);
        
    }
    
}
