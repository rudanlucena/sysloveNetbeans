package br.com.syslove.Model;

import java.util.Objects;

public class TimeLine {
    private static int serial = 0;
    private  int id;
    private String usuario;
    private String email;
    private String imagem;
    private String legenda;

    public TimeLine(){
    }

    public static int getSerial() {
        return serial;
    }

    public static void setSerial(int serial) {
        TimeLine.serial = serial;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.usuario);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.imagem);
        hash = 31 * hash + Objects.hashCode(this.legenda);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
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
        return "TimeLine{" + "id=" + id + ", usuario=" + usuario + ", email=" + email + ", imagem=" + imagem + ", legenda=" + legenda + '}';
    }  
    
}
