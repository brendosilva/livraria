package com.brendosilva;

import java.time.LocalDate;

public class Emprestimos {
    private Integer id;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String usuario;
    private boolean ativo;
    
    public Emprestimos(Integer id,Livro livro, LocalDate dataEmprestimo, String usuario) {
        this.id = id;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.usuario = usuario;
    }

    public void devolucao() {
        this.dataDevolucao = LocalDate.now();
        this.ativo = false;
        this.livro.setDisponivel(true);
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Emprestimos [id=" + id + ", livro=" + livro + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao="
                + dataDevolucao + ", usuario=" + usuario + ", ativo=" + ativo + "]";
    }

    

    
}
