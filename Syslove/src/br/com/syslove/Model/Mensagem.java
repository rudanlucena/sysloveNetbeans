package br.com.syslove.Model;

import java.util.Objects;

public class Mensagem {
    private static int serial = 0;
    private int id;
    private String remetente;
    private String destinatario;
    private String mensagem;

    public Mensagem(String remetente, String destinatario, String mensagem) {
        serial++;
        this.id = serial;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    public Mensagem() {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.remetente);
        hash = 53 * hash + Objects.hashCode(this.destinatario);
        hash = 53 * hash + Objects.hashCode(this.mensagem);
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
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.remetente, other.remetente)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensagens{" + "remetente=" + remetente + ", destinatario=" + destinatario + ", mensagem=" + mensagem + '}';
    }
    
    
}
