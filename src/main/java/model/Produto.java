package model;

public class Produto {



    private String nome;


    private Boolean isAtivo;


    private Boolean isVencido;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Boolean getVencido() {
        return isVencido;
    }

    public void setVencido(Boolean vencido) {
        isVencido = vencido;
    }

}
