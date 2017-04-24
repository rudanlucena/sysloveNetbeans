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
        
       //gu.persisteUsuario("senha", "nome", "apelido", "data", "cidade", "email", "profissao", "descricao", "status", 0, 0, "corCabelo", "fotoPerfil", "sexo");
       //System.out.println(daoU.localiza(u));
       //daoU.atualiza(u);
       //System.out.println(daoU.lista());
       //daoU.exclui(u);
        
    }
    
}
