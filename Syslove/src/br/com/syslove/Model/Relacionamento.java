package br.com.syslove.Model;

import java.util.Objects;


public class Relacionamento {
    private static int serial = 0;
    private int id;
    private String usuario1;
    private String usuario2;
    private String tipo;

    public Relacionamento(String usuario1, String usuario2, String tipo) {
        serial++;
        this.id = serial;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.tipo = tipo;
    }

    public Relacionamento() {
         
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.usuario1);
        hash = 79 * hash + Objects.hashCode(this.usuario2);
        hash = 79 * hash + Objects.hashCode(this.tipo);
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
        final Relacionamento other = (Relacionamento) obj;
        if (!Objects.equals(this.usuario1, other.usuario1)) {
            return false;
        }
        if (!Objects.equals(this.usuario2, other.usuario2)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Relacionamentos{" + "usuario1=" + usuario1 + ", usuario2=" + usuario2 + ", tipo=" + tipo + '}';
    }
    
    
}
