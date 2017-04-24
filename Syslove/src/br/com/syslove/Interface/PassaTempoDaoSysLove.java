package br.com.syslove.Interface;

import br.com.syslove.Model.PassaTempo;
import java.sql.SQLException;

/**
 *
 * @author AlexaLins
 */
public interface PassaTempoDaoSysLove {
    public boolean persiste(PassaTempo passaTempo) throws SQLException;
}
