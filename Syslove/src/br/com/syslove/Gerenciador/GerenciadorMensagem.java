package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.MensagemDaoSysLove;
import br.com.syslove.Model.Mensagem;
import java.sql.SQLException;

/**
 *
 * @author alexalins
 */
public class GerenciadorMensagem {
    private DaoFactorySysLove fabrica = null;
    private MensagemDaoSysLove mensagemDao = null;
    private DaoFactory daoFactory = null;
    
    public GerenciadorMensagem() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            mensagemDao = fabrica.criaMensagemDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de relacionamento");
        }
    }
    
    public void enviaMensagem(String remetente, String destinatario, String texto) throws SQLException{
        Mensagem mensagem = new Mensagem();
        
        mensagem.setRemetente(remetente);
        mensagem.setDestinatario(destinatario);
        mensagem.setMensagem(texto);
        
        mensagemDao.envia(mensagem);
    }
}
