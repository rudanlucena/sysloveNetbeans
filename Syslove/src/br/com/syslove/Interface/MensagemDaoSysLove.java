package br.com.syslove.Interface;

import br.com.syslove.Model.Mensagem;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;


public interface MensagemDaoSysLove {
    public boolean envia(Mensagem mensagem) throws SQLException;
}
