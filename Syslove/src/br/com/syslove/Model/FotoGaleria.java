package br.com.syslove.Model;

import java.util.Objects;


public class FotoGaleria {
    private static int serial = 0;
    private int id;
    private String usuario;
    private String imagem;
    private String legenda;

    public FotoGaleria(String usuario, String imagem, String legenda) {
        serial++;
        this.id = serial;
        this.usuario = usuario;
        this.imagem = imagem;
        this.legenda = legenda;
    }

    public FotoGaleria() {
        
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.imagem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FotoGaleria other = (FotoGaleria) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.imagem, other.imagem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GaleriaFotos{" + "usuario=" + usuario + ", imagem=" + imagem + '}';
    }
    
    
    
}
