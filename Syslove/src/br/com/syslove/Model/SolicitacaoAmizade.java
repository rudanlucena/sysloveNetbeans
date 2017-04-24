package br.com.syslove.Model;

import java.util.Objects;


public class SolicitacaoAmizade {
    private static int serial = 0;
    private int id;
    private String remetente;
    private String destinatario;

    public SolicitacaoAmizade(String remetente, String destinatario) {
        serial++;
        this.id = serial; 
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public SolicitacaoAmizade() {
        
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.remetente);
        hash = 37 * hash + Objects.hashCode(this.destinatario);
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
        final SolicitacaoAmizade other = (SolicitacaoAmizade) obj;
        if (!Objects.equals(this.remetente, other.remetente)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitacaoAmizade{" + "remetente=" + remetente + ", destinatario=" + destinatario + '}';
    }
    
    
}
