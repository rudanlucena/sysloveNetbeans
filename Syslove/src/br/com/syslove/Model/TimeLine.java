package br.com.syslove.Model;

import java.util.Objects;

public class TimeLine {
    private static int serial = 0;
    private  int id;
    private String usuario;
    private String imagem;
    private String legenda;

    public TimeLine(String usuario, String imagem, String legenda) {
        serial++;
        this.id = serial;
        this.usuario = usuario;
        this.imagem = imagem;
        this.legenda = legenda;
    }

    public TimeLine() {}

    public String getUsuario() {
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.imagem);
        hash = 89 * hash + Objects.hashCode(this.legenda);
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
        final TimeLine other = (TimeLine) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.imagem, other.imagem)) {
            return false;
        }
        if (!Objects.equals(this.legenda, other.legenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TimeLine{" + "usuario=" + usuario + ", imagem=" + imagem + ", legenda=" + legenda + '}';
    }
    
    
}
