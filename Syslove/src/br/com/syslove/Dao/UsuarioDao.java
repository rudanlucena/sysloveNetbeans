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
    

    @Override
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
                + "cidade = ?, profissao = ?, descricao = ?, status = ?, peso = ?, altura = ?, corCabelo = ?, fotoPerfil = ?, sexo = ?, email = ? WHERE email = ?";
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
        statement.setString(12, usuario.getFotoPerfil());
        statement.setString(13, usuario.getSexo());
        statement.setString(14, usuario.getEmail());
        statement.setString(15, identificacao);
        
        return statement.executeUpdate() > 0;

    }

    @Override
    public boolean exclui(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getEmail());
        
        return statement.executeUpdate()>0;
    }

    @Override
    public List<Usuario> lista() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setSenha(rs.getString(1));
            usuario.setNome(rs.getString(2));
            usuario.setApelido(rs.getString(3));
            usuario.setDataNascimento(rs.getString(4));
            usuario.setCidade(rs.getString(5));
            usuario.setEmail(rs.getString(6));
            usuario.setProfissao(rs.getString(7));
            usuario.setDescricao(rs.getString(8));
            usuario.setStatus(rs.getString(9));
            usuario.setPeso(rs.getFloat(10));
            usuario.setAltura(rs.getFloat(11));
            usuario.setCorCabelo(rs.getString(12));
            usuario.setFotoPerfil(rs.getString(13));
            usuario.setSexo(rs.getString(14));

            usuarios.add(usuario);
        }
        return usuarios;
    }
}
