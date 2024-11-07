package com.brendosilva;

import java.time.LocalDate;


public class Livro {

    private Integer id;
    private String titulo;
    private Autor autor;
    private Boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro (Integer id, String titulo, Autor autor) {
        this.dataCadastro = LocalDate.now();
        this.id = id;
        this.disponivel = true;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponivel=" + disponivel
                + ", dataCadastro=" + dataCadastro + " disponibilidade: " + this.disponivel + "]";
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }    

    
    

}
