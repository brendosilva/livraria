package com.brendosilva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private List<Livro> livrosEmprestado;

    public Cliente(int id, String nome, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome= nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.livrosEmprestado = new ArrayList<>();
    }


    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
    }

    


    
}
