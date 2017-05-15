package br.com.syslove.Gerenciador;

import br.com.syslove.Exception.PersistenciaException;
import br.com.syslove.Factory.DaoFactory;
import br.com.syslove.Interface.DaoFactorySysLove;
import br.com.syslove.Interface.UsuarioDaoSysLove;
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
    
    public Usuario localizaUsuario(String email, String senha) throws PersistenciaException, SQLException{
        return usuarioDao.localiza(email, senha);
    }
    
    public Usuario atualizaUsuario(String email, String senha, String nome, String apelido, String dataNascimento, String cidade, String profissao, String descricao, String status, double peso, double altura, String corCabelo, String sexo, String passaTempo, String identificacao, String fotoPerfil) throws PersistenciaException, SQLException{        
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
        novoUsuario.setSexo(sexo);
        novoUsuario.setPassaTempo(passaTempo);
        novoUsuario.setFotoPerfil(fotoPerfil);
        if(usuarioDao.atualiza(novoUsuario, identificacao))
            return novoUsuario;
        else
            return null;
    }
    
    public void atualizaFotoPerfil(String email, String imagem) throws SQLException {
        usuarioDao.atualizaFotoPerfil(email, imagem);
    }
    
    public void excluiUsuario(String email) throws SQLException{        
        usuarioDao.exclui(email);
    }
    
    public List<Usuario> listaUsuario(String nome, String cidade, String sexo) throws SQLException{
        if(nome.equals(""))
            nome = null;
        if(cidade.equals(""))
            cidade = null;
        if(sexo.equals(""))
            sexo = null;
        List<Usuario> usuarios;
        
        usuarios = usuarioDao.lista(nome, cidade, sexo);
        if(usuarios.isEmpty())
            return null;
        
        return usuarios;
    }
    
    public List<Usuario> listaAmigos(String email, String nome) throws SQLException{
        List<Usuario> usuarios;
        
        usuarios = usuarioDao.listaAmigos(email, nome);
        
        if(usuarios.isEmpty())
            return null;
        
        return usuarios;
    }
    
    public Usuario busca(String email) throws SQLException{
        return usuarioDao.busca(email);
    }
}
