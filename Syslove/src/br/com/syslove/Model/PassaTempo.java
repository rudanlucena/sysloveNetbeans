package br.com.syslove.Model;

import java.util.Objects;


public class PassaTempo {
    private static int serial = 0;
   private int id;
   private String usuario;
   private String passatempo;

    public PassaTempo(String usuario, String passatempo) {
        serial++;
        this.id = serial;
        this.usuario = usuario;
        this.passatempo = passatempo;
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

    public String getPassatempo() {
        return passatempo;
    }

    public void setPassatempo(String passatempo) {
        this.passatempo = passatempo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.passatempo);
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
        final PassaTempo other = (PassaTempo) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.passatempo, other.passatempo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PassaTempos{" + "usuario=" + usuario + ", passatempo=" + passatempo + '}';
    }
   
}
