package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.GaleriaDaoSysLove;
import br.com.syslove.Model.FotoGaleria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class GerenciadorFotoGaleria {
    private DaoFactorySysLove fabrica = null;
    private GaleriaDaoSysLove fotoGaleriaDao = null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorFotoGaleria() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            fotoGaleriaDao = fabrica.criaGaleriaDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de relacionamento");
        }
    }
    
    public void persisteFotoGaleria(String usuario, String foto, String legenda) throws SQLException{
        FotoGaleria fotoGaleria = new FotoGaleria();
        
        fotoGaleria.setUsuario(usuario);
        fotoGaleria.setImagem(foto);
        fotoGaleria.setLegenda(legenda);
        
        fotoGaleriaDao.persiste(fotoGaleria);
    }
    
    public void excluiFotoGaleria(String usuario, String foto) throws SQLException{
        FotoGaleria fotoGaleria = new FotoGaleria();
        
        fotoGaleria.setUsuario(usuario);
        fotoGaleria.setImagem(foto);
        
        fotoGaleriaDao.exclui(fotoGaleria);
    }
    
    public List<FotoGaleria> listaFotoGaleria() throws SQLException{
        List<FotoGaleria> fotos = new ArrayList<>();
        
        fotos = fotoGaleriaDao.lista();
        
        return fotos;
    }
        
}
