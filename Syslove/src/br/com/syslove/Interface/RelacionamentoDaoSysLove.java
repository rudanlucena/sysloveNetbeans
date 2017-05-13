package br.com.syslove.Interface;

import br.com.syslove.Model.Relacionamento;
import java.sql.SQLException;
import java.util.List;


public interface RelacionamentoDaoSysLove {
    public boolean novo(Relacionamento relacionamento) throws SQLException;
    public boolean atualiza(Relacionamento relacionamento) throws SQLException;
    public boolean desfaz(Relacionamento relacionamento) throws SQLException;
    public List<Relacionamento> lista() throws SQLException;
    public boolean verificaAmizade(String remetente, String destinatario) throws SQLException;
}
