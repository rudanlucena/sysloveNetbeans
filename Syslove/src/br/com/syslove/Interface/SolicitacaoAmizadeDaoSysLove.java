package br.com.syslove.Interface;

import br.com.syslove.Model.Relacionamento;
import br.com.syslove.Model.SolicitacaoAmizade;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface SolicitacaoAmizadeDaoSysLove {
    public boolean solicita(SolicitacaoAmizade solicitacao) throws SQLException;
    public boolean exclui(SolicitacaoAmizade solicitacao) throws SQLException;
    public boolean aceita(SolicitacaoAmizade solicitacao) throws SQLException;
    public List<Usuario> lista(String email) throws SQLException;
    public boolean solicitacaoEnviada(String usuario, String email) throws SQLException;
    public boolean solicitacaoRecebida(String usuario, String email) throws SQLException;
}
