package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.RecomendacaoAmizadeDaoSysLove;
import br.com.syslove.Model.RecomendacaoAmizade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class GerenciadorRecomendacaoAmizade {
    private DaoFactorySysLove fabrica = null;
    private RecomendacaoAmizadeDaoSysLove recomendacaoAmizadeDao = null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorRecomendacaoAmizade() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            recomendacaoAmizadeDao = fabrica.criaRecomendacaoAmizadeDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de usuario");
        }
    }
    
    public void recomendaAmizade(String rementente, String destinatario, String recomendacao) throws SQLException{
        RecomendacaoAmizade recomendacaoAmizade = new RecomendacaoAmizade();
        
        recomendacaoAmizade.setRecomendacao(recomendacao);
        recomendacaoAmizade.setRemetente(rementente);
        recomendacaoAmizade.setDestinatario(destinatario);
        
        recomendacaoAmizadeDao.recomenda(recomendacaoAmizade);
    }
    
    public List<RecomendacaoAmizade> listaRecomendaAmizade() throws SQLException{
        List<RecomendacaoAmizade> amizades = new ArrayList<>();
        
        amizades = recomendacaoAmizadeDao.lista();
        
        return amizades;
    }
}
