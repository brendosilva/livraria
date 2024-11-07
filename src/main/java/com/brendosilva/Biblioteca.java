package com.brendosilva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros;
    public List<Livro> getLivros() {
        return livros;
    }

    private List<Autor> autores;
    private List<Emprestimos> emprestimos;
    private List<Cliente> clientes;

    public List<Autor> getAutores() {
        return autores;
    }

    public Biblioteca () {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) throws Exception {
        
        for(Livro livroInteracao : livros) {
           
              if (livroInteracao.getId() == livro.getId()) {
                throw new Exception("id já cadastrado");
              }  

              if (livroInteracao.getTitulo().equalsIgnoreCase(livro.getTitulo()) &&
              livroInteracao.getAutor().getNome().equalsIgnoreCase(livro.getAutor().getNome())) {
               String err = "O livro: " + livro.getTitulo() + " do autor: " +  livro.getAutor().getNome() + " já foi cadastrado!!"; 
                
                throw new Exception(err);
              }
            
        }

        this.livros.add(livro);
    }
    public void cadastroCliente(Cliente cliente) throws Exception {
        for (Cliente clienteInteracao : clientes) {
            if (clienteInteracao.getId() == cliente.getId()) {
                throw new Exception("id já cadastrado");
              }  
            if (clienteInteracao.getEmail().equals(cliente.getEmail())) {
                throw new Exception("email já cadastrado");
            }
        }

        this.clientes.add(cliente);
        
    }

    public void adicionarAutor(Autor autor) throws Exception {
        for (Autor autorIteracao : autores) {
            if (autorIteracao.getId() == autor.getId()) {
                throw new Exception("id já cadastrado");
            } 

            if (autorIteracao.getNome().equalsIgnoreCase(autor.getNome())) {
                throw new Exception("Autor já cadastrado");
            }
        }
        this.autores.add( autor);
    }

    public ArrayList<Livro> listagemLivrosDisponiveis() {
        
        ArrayList<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }

        return livrosDisponiveis;
    }

    public void emprestarLivro(Livro livro, String usuario) {
        if(livro.getDisponivel()) {
            Emprestimos emprestimo = new Emprestimos(1, livro, LocalDate.now(), usuario);
            livro.setDisponivel(false);
            this.emprestimos.add(emprestimo);
        } else {
            System.err.println("Indisponivel para emprestimo");
        }
    }

    public void devolucaoLivro(int idEmprestimo) {
        for (Emprestimos emprestimo : this.emprestimos) {
            if (emprestimo.getId() == idEmprestimo) {
                emprestimo.devolucao();
                break;
            }
        }
    }

    public List<Emprestimos> listagemEmprestimos() {
        return emprestimos;
    }

    public Livro burcarLivroPorId(int idLivro) {
        
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                return livro;
            }
        }
        

        return null;
    
    }

    public Livro buscarLivroPorTitulo (String titulo)  {
        titulo = titulo.toLowerCase();
        
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            } 
        }
        return null;
    }

    public Cliente buscarClientePorEmail (String email){
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    public Autor buscarAutorPorId (Integer id) {
        Autor autorEncontrado = null ;
        for (Autor autor : autores) {
            if (autor.getId().equals(id) ) {
                 autorEncontrado = autor;
            }
        }

        return autorEncontrado;

        
    }

    

}
