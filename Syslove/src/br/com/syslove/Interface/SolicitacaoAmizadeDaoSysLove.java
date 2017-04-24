package br.com.syslove.Interface;

import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
import java.sql.SQLException;
import java.util.List;


public interface SolicitacaoAmizadeDaoSysLove {
    public boolean solicita(SolicitacaoAmizade solicitacao) throws SQLException;
    public boolean rejeita(SolicitacaoAmizade solicitacao) throws SQLException;
    public boolean aceita(Relacionamento relacionamento) throws SQLException;
    public List<SolicitacaoAmizade> lista() throws SQLException;
}
