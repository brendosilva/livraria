package com.brendosilva;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    
    //Criando Autores e livros
    Autor autor01 = new Autor(1,"Nick", LocalDate.of(1980, 10, 5));
    Autor autor02 = new Autor(2, "Nick Ramos", LocalDate.of(1980, 10, 5));  

    Livro livro01 = new Livro(1,"java", autor02);
    Livro livro02 = new Livro(2, "Java2", autor01);

    
    // Adicionando Autores e livros na biblioteca
    try {
        biblioteca.adicionarAutor(autor02);
        biblioteca.adicionarAutor(autor01);
        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);
    } catch (Exception e) {
        
        e.printStackTrace();
    }

    while (true) {
        System.out.println("Deseja ver os livros disponíveis? (sim/nao)");
        String resposta = scanner.nextLine().toLowerCase();

        if (resposta.equals("sim")) {
            List<Livro> livrosDisponiveis = biblioteca.listagemLivrosDisponiveis();

            if (livrosDisponiveis.isEmpty()) {
                System.out.println("Não há livros disponíveis no momento.");
            } else {
                System.out.println("Livros disponíveis:");
                for (Livro livro : livrosDisponiveis) {
                    System.out.println(livro.getId() + ": " + livro.getTitulo());
                }

                System.out.println("Digite o ID do livro que você deseja emprestar:");
                int idLivro = scanner.nextInt();
                scanner.nextLine();

                Livro livroSelecionado = biblioteca.burcarLivroPorId(idLivro);

                if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
                    System.out.println("Digite seu nome:");
                    String nomeUsuario = scanner.nextLine();

                    biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                    System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
                } else {
                    System.err.println("Livro não encontrado ou não disponível para empréstimo.");
                }
            }
        } else if (resposta.equals("nao")) {
            System.out.println("Obrigado por utilizar o sistema da biblioteca.");
            break; 
        } else {
            System.err.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
        }
    }

    scanner.close();
    
    

    
    }
    
}