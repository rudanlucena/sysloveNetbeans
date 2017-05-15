package br.com.syslove.Interface;

import br.com.syslove.Model.Mensagem;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface MensagemDaoSysLove {
    public boolean envia(Mensagem mensagem) throws SQLException;
    public List<Usuario> listarNovas(String email) throws SQLException;
}
