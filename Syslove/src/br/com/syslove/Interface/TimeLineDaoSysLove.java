package br.com.syslove.Interface;

import br.com.syslove.Model.TimeLine;
import java.sql.SQLException;
import java.util.List;

public interface TimeLineDaoSysLove {
    public boolean publica(TimeLine post) throws SQLException;
    public List<TimeLine> lista(String email) throws SQLException;
}
