package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.TimeLineDaoSysLove;
import br.com.syslove.Model.FotoGaleria;
import br.com.syslove.Model.TimeLine;
import java.sql.SQLException;

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
    
    public void persisteTimeLine(String usuario, String foto, String legenda) throws SQLException{
        FotoGaleria fotoGaleria = new FotoGaleria();
        
        fotoGaleria.setUsuario(usuario);
        fotoGaleria.setImagem(legenda);
        fotoGaleria.setLegenda(legenda);
        
        timeLineDao.publica(fotoGaleria);
    }
    
}
