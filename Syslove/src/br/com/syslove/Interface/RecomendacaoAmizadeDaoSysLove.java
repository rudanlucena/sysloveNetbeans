package br.com.syslove.Interface;

import br.com.syslove.Model.RecomendacaoAmizade;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface RecomendacaoAmizadeDaoSysLove {
    public boolean recomenda(RecomendacaoAmizade recomendacao)throws SQLException;
    public List<RecomendacaoAmizade> lista() throws SQLException;
}
