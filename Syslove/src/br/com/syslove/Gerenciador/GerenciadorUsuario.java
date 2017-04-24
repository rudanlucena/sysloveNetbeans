package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.UsuarioDaoSysLove;
import br.com.syslove.Model.PassaTempo;
import br.com.syslove.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
    private DaoFactorySysLove fabrica = null;
    private UsuarioDaoSysLove usuarioDao = null;
    private DaoFactory daoFactory = null;

    public GerenciadorUsuario() throws PersistenciaException {
        daoFactory = new DaoFactory();
        fabrica = daoFactory.createFactory();
        try{
            usuarioDao = fabrica.criaUsuarioDao();
        }catch(PersistenciaException pe){
            throw new PersistenciaException("falha no gerenciador de usuario");
        }
    }
    
    public void persisteUsuario(String email, String senha, String nome, String apelido, String dataNascimento, String cidade, String profissao, String descricao, String status, double peso, double altura, String corCabelo, String fotoPerfil, String sexo, String passaTempo) throws PersistenciaException, SQLException{        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setNome(nome);
        novoUsuario.setApelido(apelido);
        novoUsuario.setDataNascimento(dataNascimento);
        novoUsuario.setCidade(cidade);
        novoUsuario.setProfissao(profissao);
        novoUsuario.setDescricao(descricao);
        novoUsuario.setStatus(status);
        novoUsuario.setPeso(peso);
        novoUsuario.setAltura(altura);
        novoUsuario.setCorCabelo(corCabelo);
        novoUsuario.setFotoPerfil(fotoPerfil);
        novoUsuario.setSexo(sexo);
        novoUsuario.setPassaTempo(passaTempo);
        usuarioDao.persiste(novoUsuario);
    }
    
    public boolean localizaUsuario(String email, String senha) throws PersistenciaException, SQLException{
        return usuarioDao.localiza(email, senha);
    }
    
    public void atualizaUsuario(String email, String senha, String nome, String apelido, String dataNascimento, String cidade, String profissao, String descricao, String status, float peso, float altura, String corCabelo, String fotoPerfil, String sexo, String passaTempo) throws PersistenciaException, SQLException{        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setNome(nome);
        novoUsuario.setApelido(apelido);
        novoUsuario.setDataNascimento(dataNascimento);
        novoUsuario.setCidade(cidade);
        novoUsuario.setProfissao(profissao);
        novoUsuario.setDescricao(descricao);
        novoUsuario.setStatus(status);
        novoUsuario.setPeso(peso);
        novoUsuario.setAltura(altura);
        novoUsuario.setCorCabelo(corCabelo);
        novoUsuario.setFotoPerfil(fotoPerfil);
        novoUsuario.setSexo(sexo);
        novoUsuario.setPassaTempo(passaTempo);
        usuarioDao.atualiza(novoUsuario);
    }
    
    public void excluiUsuario(String email) throws SQLException{
        Usuario novoUsuario = new Usuario();
        
        novoUsuario.setEmail(email);
        
        usuarioDao.exclui(novoUsuario);
    }
    
    public List<Usuario> listaUsuario() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        
        usuarios = usuarioDao.lista();
        
        return usuarios;
    }
}
