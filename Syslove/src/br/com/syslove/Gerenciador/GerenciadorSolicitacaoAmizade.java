package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.SolicitacaoAmizadeDaoSysLove;
import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class GerenciadorSolicitacaoAmizade {
    private DaoFactorySysLove fabrica = null;
    private SolicitacaoAmizadeDaoSysLove solicitacaoAmizadeDao= null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorSolicitacaoAmizade() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            solicitacaoAmizadeDao = fabrica.criaSolicitacaoAmizadeDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de relacionamento");
        }
    }
    
    public void solicitaAmizade(String rementente, String destinatario) throws SQLException{
        SolicitacaoAmizade solicitacaoAmizade = new SolicitacaoAmizade();
        
        solicitacaoAmizade.setRemetente(rementente);
        solicitacaoAmizade.setDestinatario(destinatario);
        
        solicitacaoAmizadeDao.solicita(solicitacaoAmizade);
    }
    
    public void aceitaSolicitacaoAmizade(String remetente, String destinatario) throws SQLException{
        SolicitacaoAmizade solicitacao = new SolicitacaoAmizade();
        
        solicitacao.setRemetente(remetente);
        solicitacao.setDestinatario(destinatario);
                
        solicitacaoAmizadeDao.aceita(solicitacao);
    }
    
    public void rejeitaSolicitacaoAmizade(String remetente, String Destinatario) throws SQLException{
        SolicitacaoAmizade solicitacaoAmizade = new SolicitacaoAmizade();
        
        solicitacaoAmizade.setDestinatario(Destinatario);
        solicitacaoAmizade.setRemetente(remetente);
        
        solicitacaoAmizadeDao.exclui(solicitacaoAmizade);
    }
    
    public List<Usuario> listaSolicitacaoAmizade(String email) throws SQLException{
        List<Usuario> usuarios;
        
        usuarios = solicitacaoAmizadeDao.lista(email);
        if(usuarios.isEmpty())
            return null;
        
        return usuarios;
    }
    
    public boolean solicitacaoEnviada(String usuario, String email) throws SQLException{
        return solicitacaoAmizadeDao.solicitacaoEnviada(usuario, email);
    }
    public boolean solicitacaoRecebida(String usuario, String email) throws SQLException{
        return solicitacaoAmizadeDao.solicitacaoRecebida(usuario, email);
    }
}
