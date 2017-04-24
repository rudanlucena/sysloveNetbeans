package br.com.syslove.Interface;

import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoSysLove {
    public void persiste(Usuario usuario) throws SQLException;
    public boolean localiza(String email, String senha) throws SQLException;
    public boolean atualiza(Usuario usuario) throws SQLException;
    public boolean exclui(Usuario usuario) throws SQLException;
    public List<Usuario> lista() throws SQLException;
}
