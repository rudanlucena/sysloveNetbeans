/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syslove.Dao;

import br.com.syslove.Interface.UsuarioDaoSysLove;
import br.com.syslove.Model.Usuario;
import br.com.syslove.Exception.ConnectionException;
import br.com.syslove.Conexao.ConnectionFactory;
import br.com.syslove.Exception.DiretorioImagensException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements UsuarioDaoSysLove {

    private final Connection connection;

    public UsuarioDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }

    @Override
    public void persiste(Usuario usuario) throws SQLException{
        
                   
        boolean success = (new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\syslove\\img\\"+usuario.getEmail())).mkdirs();
        if (!success) {
            //throw new DiretorioImagensException("erro ao criar o diretorio");
        }
        
       
        String sql = "INSERT INTO usuarios (senha, nome, apelido, dataNascimento, cidade, email, profissao, descricao, status, peso, altura,corCabelo, fotoPerfil, sexo, passaTempo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getApelido());
        statement.setString(4, usuario.getDataNascimento());
        statement.setString(5, usuario.getCidade());
        statement.setString(6, usuario.getEmail());
        statement.setString(7, usuario.getProfissao());
        statement.setString(8, usuario.getDescricao());
        statement.setString(9, usuario.getStatus());
        statement.setDouble(10, usuario.getPeso());
        statement.setDouble(11, usuario.getAltura());
        statement.setString(12, usuario.getCorCabelo());
        statement.setString(13, usuario.getFotoPerfil());
        statement.setString(14, usuario.getSexo());
        statement.setString(15, usuario.getPassaTempo());

        statement.executeUpdate();
    }
    

    @Override //renomear para login
    public Usuario localiza(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        statement.setString(2, senha);
        ResultSet rs = statement.executeQuery();
        Usuario usuario = null; 
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setSenha(rs.getString("senha"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setDescricao(rs.getString("descricao"));
            usuario.setPassaTempo(rs.getString("passaTempo"));
            usuario.setStatus(rs.getString("status"));
            usuario.setPeso(rs.getDouble("peso"));
            usuario.setAltura(rs.getDouble("altura"));
            usuario.setCorCabelo(rs.getString("corCabelo"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setSexo(rs.getString("sexo"));
        }
        return usuario;
    }

    @Override
    public boolean atualiza(Usuario usuario, String identificacao) throws SQLException {
        
        String sql = "UPDATE usuarios SET senha = ?, nome = ?, apelido = ?, dataNascimento = ?,"
                + "cidade = ?, profissao = ?, descricao = ?, status = ?, peso = ?, altura = ?, corCabelo = ?, sexo = ?, email = ? WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getApelido());
        statement.setString(4, usuario.getDataNascimento());
        statement.setString(5, usuario.getCidade());
        statement.setString(6, usuario.getProfissao());
        statement.setString(7, usuario.getDescricao());
        statement.setString(8, usuario.getStatus());
        statement.setDouble(9, usuario.getPeso());
        statement.setDouble(10, usuario.getAltura());
        statement.setString(11, usuario.getCorCabelo());
        statement.setString(12, usuario.getSexo());
        statement.setString(13, usuario.getEmail());
        statement.setString(14, identificacao);
        
        return statement.executeUpdate() > 0;

    }
    
    @Override
    public boolean atualizaFotoPerfil(String email, String imagem)throws SQLException {
        String sql="UPDATE usuarios SET fotoPerfil = ? WHERE email = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, imagem);
        statement.setString(2, email);
        
        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean exclui(String email) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        
        return statement.executeUpdate()>0;
    }

    @Override
    public List<Usuario> lista(String nome, String cidade, String sexo) throws SQLException {
        String SQLEmpty = "SELECT * FROM usuarios";
        String SQLNomeCidadeSexo = "SELECT * FROM usuarios where nome ilike ? and cidade = ? and sexo = ?";
        String SQLNome= "SELECT * FROM usuarios where nome ilike ?";
        String SQLCidade= "SELECT * FROM usuarios where cidade ilike ?";
        String SQLSexo= "SELECT * FROM usuarios where sexo = ?";
        String SQLNomeCidade = "SELECT * FROM usuarios where nome ilike ? and cidade = ?";
        String SQLNomeSexo = "SELECT * FROM usuarios where nome ilike ? and sexo = ?";
        String SQLCidadesexo = "SELECT * FROM usuarios where cidade ilike ? and sexo = ?";
        
        PreparedStatement statement = connection.prepareStatement(SQLEmpty);
        
        if((nome == null) && (cidade == null) && (sexo == null)){
            statement = connection.prepareStatement(SQLEmpty);
        }else if((nome != null) && (cidade != null) && (sexo != null)){
            statement = connection.prepareStatement(SQLNomeCidadeSexo);
            statement.setString(1, nome);
            statement.setString(2, cidade);
            statement.setString(3, sexo);
        }else{
            if((nome != null) && (cidade == null) && (sexo == null)){
                statement = connection.prepareStatement(SQLNome);
                statement.setString(1, nome);
            }
            else if((cidade != null) && (nome == null) && (sexo== null)){
                statement = connection.prepareStatement(SQLCidade);
                statement.setString(1, cidade);
            }
            else if((sexo != null) && (nome == null) && (cidade == null)){
                statement = connection.prepareStatement(SQLSexo);
                statement.setString(1, sexo);
            }
            else if((nome != null) && (cidade != null) && (sexo == null)){
                statement = connection.prepareStatement(SQLNomeCidade);
                statement.setString(1, nome);
                statement.setString(2, cidade);
            }
            else if((nome != null) && (sexo != null) && (cidade == null)){
                statement = connection.prepareStatement(SQLNomeSexo);
                statement.setString(1, nome);
                statement.setString(2, sexo);
            }
            else if((cidade != null) && (sexo != null) && (nome == null)){
                statement = connection.prepareStatement(SQLCidadesexo);
                statement.setString(1, cidade);
                statement.setString(2, sexo);
            }
        }
        
        ResultSet rs = statement.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setSenha(rs.getString("senha"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setDescricao(rs.getString("descricao"));
            usuario.setStatus(rs.getString("status"));
            usuario.setPeso(rs.getFloat("peso"));
            usuario.setAltura(rs.getFloat("altura"));
            usuario.setCorCabelo(rs.getString("corCabelo"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setSexo(rs.getString("sexo"));

            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> listaAmigos(String email, String nome) throws SQLException {
        String sqlListAll = "SELECT * FROM usuarios u, relacionamentos r where (r.usuario1 = u.email or r.usuario2 = u.email) and (r.usuario1 = ? or r.usuario2 = ?) and u.email != ?";
        String sqlListName = "SELECT * FROM usuarios u, relacionamentos r where (r.usuario1 = u.email or r.usuario2 = u.email) and (r.usuario1 = ? or r.usuario2 = ?) and u.email != ? and u.nome = ?";
        PreparedStatement statement;
        if(nome == null){
             statement = connection.prepareStatement(sqlListAll);
        }else{
             statement = connection.prepareStatement(sqlListName);
             statement.setString(4, nome);
        }
             
        statement.setString(1, email);
        statement.setString(2, email);
        statement.setString(3, email);

        ResultSet rs = statement.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setSenha(rs.getString("senha"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setDescricao(rs.getString("descricao"));
            usuario.setStatus(rs.getString("status"));
            usuario.setPeso(rs.getFloat("peso"));
            usuario.setAltura(rs.getFloat("altura"));
            usuario.setCorCabelo(rs.getString("corCabelo"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setSexo(rs.getString("sexo"));

            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public Usuario busca(String email) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        
        ResultSet rs = statement.executeQuery();
        Usuario usuario = null; 
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setSenha(rs.getString("senha"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            usuario.setDataNascimento(rs.getString("dataNascimento"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEmail(rs.getString("email"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setDescricao(rs.getString("descricao"));
            usuario.setPassaTempo(rs.getString("passaTempo"));
            usuario.setStatus(rs.getString("status"));
            usuario.setPeso(rs.getDouble("peso"));
            usuario.setAltura(rs.getDouble("altura"));
            usuario.setCorCabelo(rs.getString("corCabelo"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setSexo(rs.getString("sexo"));
        }
        return usuario;
    }
}
