package br.com.syslove.Interface;

import br.com.syslove.Exception.PersistenciaException;

public interface DaoFactorySysLove {
    public GaleriaDaoSysLove criaGaleriaDao() throws PersistenciaException;
    public MensagemDaoSysLove criaMensagemDao() throws PersistenciaException;
    public PassaTempoDaoSysLove criaPassaTempoDao() throws PersistenciaException;
    public RecomendacaoAmizadeDaoSysLove criaRecomendacaoAmizadeDao() throws PersistenciaException;
    public RelacionamentoDaoSysLove criaRelacionamentoDao() throws PersistenciaException;
    public SolicitacaoAmizadeDaoSysLove criaSolicitacaoAmizadeDao() throws PersistenciaException;
    public TimeLineDaoSysLove criaTimeLineDao() throws PersistenciaException;
    public UsuarioDaoSysLove criaUsuarioDao() throws PersistenciaException;
}