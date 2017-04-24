package br.com.syslove.Gerenciador;


import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.RelacionamentoDaoSysLove;
import br.com.syslove.Model.Relacionamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class GerenciadorRelacionamento {
    private DaoFactorySysLove fabrica = null;
    private RelacionamentoDaoSysLove RelacionamentoDao = null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorRelacionamento() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            RelacionamentoDao = fabrica.criaRelacionamentoDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de relacionamento");
        }
    }
    
    public void persisteRelacionamento(String usuario1, String usuario2, String tipo) throws SQLException{
        Relacionamento relacionamento = new Relacionamento();
        
        relacionamento.setUsuario1(usuario1);
        relacionamento.setUsuario2(usuario2);
        relacionamento.setTipo(tipo);
        
        RelacionamentoDao.novo(relacionamento);
    }
    
    public void atualizaRelacionamento(String usuario1, String usuario2, String tipo) throws SQLException{
        Relacionamento relacionamento = new Relacionamento();
        
        relacionamento.setUsuario1(usuario1);
        relacionamento.setUsuario2(usuario2);
        relacionamento.setTipo(tipo);
        
        RelacionamentoDao.atualiza(relacionamento);
    }
    
    public void excluiRelacionamento(String usuario1, String usuario2) throws SQLException{
        Relacionamento relacionamento = new Relacionamento();
        
        relacionamento.setUsuario1(usuario1);
        relacionamento.setUsuario2(usuario2);
        
        RelacionamentoDao.desfaz(relacionamento);
    }
    
    public List<Relacionamento> listaRelacionamento() throws SQLException{
        List<Relacionamento> relacionamentos = new ArrayList<>();
        
        relacionamentos = RelacionamentoDao.lista();
        
        return relacionamentos;
    }
}
