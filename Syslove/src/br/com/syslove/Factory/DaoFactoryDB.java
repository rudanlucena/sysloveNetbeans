package br.com.syslove.Factory;

import br.com.syslove.Dao.*;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Interface.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFactoryDB implements DaoFactorySysLove{
    
    private DaoFactoryDB instance;

    @Override
    public GaleriaDaoSysLove criaGaleriaDao() throws PersistenciaException {
        try{
            return new FotoGaleriaDao();
        }
        catch(ConnectionException | ClassNotFoundException | SQLException exc){
            throw new PersistenciaException("falha na criacao da GaleriaDao");
        }
        
    }

    @Override
    public MensagemDaoSysLove criaMensagemDao()  throws PersistenciaException  {
        try {
            return new MensagemDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao da MenssagemDao");
        }
    }

    @Override
    public PassaTempoDaoSysLove criaPassaTempoDao() throws PersistenciaException {
        try {
            return new PassaTempoDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao do PassatempoDao");
        }
    }

    @Override
    public RecomendacaoAmizadeDaoSysLove criaRecomendacaoAmizadeDao() throws PersistenciaException {
        try {
            return new RecomendacaoAmizadeDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao da RecomendacaoAmizadeDao");
        }
    }

    @Override
    public RelacionamentoDaoSysLove criaRelacionamentoDao() throws PersistenciaException  {
        try {
            return new RelacionamentoDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao do RelacionamentoDao");
        }
    }

    @Override
    public SolicitacaoAmizadeDaoSysLove criaSolicitacaoAmizadeDao() throws PersistenciaException {
        try {
            return new SolicitacaoAmizadeDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao da SolicitacaoAmizadeDaoDao");
        }
    }

    @Override
    public TimeLineDaoSysLove criaTimeLineDao() throws PersistenciaException {
        try {
            return new TimeLineDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao da TimeLineDao");
        }
    }

    @Override
    public UsuarioDaoSysLove criaUsuarioDao() throws PersistenciaException {
        try {
            return new UsuarioDao();
        } catch (ConnectionException | ClassNotFoundException | SQLException ex) {
            throw new PersistenciaException("falha na criacao do UsuarioDao");
        }
    }
    
}
