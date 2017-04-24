package br.com.syslove.Model;

import java.util.Objects;

public class RecomendacaoAmizade {
    private static int serial = 0;
    private int id;
    private String remetente;
    private String destinatario;
    private String recomendacao;

    public RecomendacaoAmizade(String remetente, String destinatario, String recomendacao) {
        serial++;
        this.id = serial;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.recomendacao = recomendacao;
    }

    public RecomendacaoAmizade() {
       
    }

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

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.remetente);
        hash = 83 * hash + Objects.hashCode(this.destinatario);
        hash = 83 * hash + Objects.hashCode(this.recomendacao);
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
        final RecomendacaoAmizade other = (RecomendacaoAmizade) obj;
        if (!Objects.equals(this.remetente, other.remetente)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        if (!Objects.equals(this.recomendacao, other.recomendacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecomendacoesAmizade{" + "remetente=" + remetente + ", destinatario=" + destinatario + ", recomendacao=" + recomendacao + '}';
    }
    
    
    
}
