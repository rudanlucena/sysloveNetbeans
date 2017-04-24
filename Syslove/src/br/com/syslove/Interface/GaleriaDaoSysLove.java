package br.com.syslove.Interface;

import br.com.syslove.Model.FotoGaleria;
import java.sql.SQLException;
import java.util.List;

public interface GaleriaDaoSysLove {
    public boolean persiste(FotoGaleria fotoUsuario) throws SQLException;
    public boolean exclui(FotoGaleria fotoUsuario) throws SQLException;
    public List<FotoGaleria> lista() throws SQLException;
}
