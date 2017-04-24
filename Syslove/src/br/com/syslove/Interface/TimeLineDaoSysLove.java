package br.com.syslove.Interface;

import br.com.syslove.Model.FotoGaleria;
import java.sql.SQLException;

public interface TimeLineDaoSysLove {
    public boolean publica(FotoGaleria imagem) throws SQLException;
}
