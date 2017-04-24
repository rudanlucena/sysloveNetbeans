package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.SolicitacaoAmizadeDaoSysLove;
import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
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
    
    public void solicitaSolicitacaoAmizade(String rementente, String destinatario) throws SQLException{
        SolicitacaoAmizade solicitacaoAmizade = new SolicitacaoAmizade();
        
        solicitacaoAmizade.setRemetente(rementente);
        solicitacaoAmizade.setDestinatario(destinatario);
        
        solicitacaoAmizadeDao.solicita(solicitacaoAmizade);
    }
    
    public void aceitaSolicitacaoAmizade(String Usuario1, String Usuario2, String tipo) throws SQLException{
        Relacionamento relacionamento = new Relacionamento();
        
        relacionamento.setUsuario1(Usuario1);
        relacionamento.setUsuario2(Usuario2);
        relacionamento.setTipo(tipo);
        
        solicitacaoAmizadeDao.aceita(relacionamento);
    }
    
    public void rejeitaSolicitacaoAmizade(String remetente, String Destinatario) throws SQLException{
        SolicitacaoAmizade solicitacaoAmizade = new SolicitacaoAmizade();
        
        solicitacaoAmizade.setDestinatario(Destinatario);
        solicitacaoAmizade.setRemetente(remetente);
        
        solicitacaoAmizadeDao.rejeita(solicitacaoAmizade);
    }
    
    public List<SolicitacaoAmizade> listaSolicitacaoAmizade() throws SQLException{
        List<SolicitacaoAmizade> solicitacaoAmizade = new ArrayList<>();
        
        solicitacaoAmizade = solicitacaoAmizadeDao.lista();
        
        return solicitacaoAmizade;
    }
}
