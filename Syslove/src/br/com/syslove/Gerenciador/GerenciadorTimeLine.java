package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.TimeLineDaoSysLove;
import br.com.syslove.Model.FotoGaleria;
import br.com.syslove.Model.TimeLine;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class GerenciadorTimeLine {
    private DaoFactorySysLove fabrica = null;
    private TimeLineDaoSysLove timeLineDao = null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorTimeLine() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            timeLineDao = fabrica.criaTimeLineDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de relacionamento");
        }
    }
    
    public void persisteTimeLine(String usuario, String imagem, String legenda) throws SQLException{
        TimeLine post = new TimeLine();
        
        post.setUsuario(usuario);
        post.setImagem(imagem);
        post.setLegenda(legenda);
        
        timeLineDao.publica(post);
    }
    
    public List<TimeLine> lista(String email) throws SQLException{
        List<TimeLine> posts = timeLineDao.lista(email);
        if(posts.isEmpty())
            return null;
        return posts;
    }
    
}
