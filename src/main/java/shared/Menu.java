package shared;

import modules.biblioteca.BibliotecaController;
import modules.livro.LivroController;
import modules.usuario.UsuarioController;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    static LocalDateTime date = LocalDateTime.now();
    public static void opcoes() {
        System.out.println("\nMenu de Opções: ");
        System.out.println("\t1 - Listar Todos os Usuários - P");
        System.out.println("\t2 - Listar Todos os Livros - P");
        System.out.println("\t3 - Criar um Novo Livro - P");
        System.out.println("\t4 - Criar um Novo Usuário - P");
        System.out.println("\t5 - Emprestar/Devolver um Livro");
        System.out.println("\t6 - Ver Livros em Atraso");
        System.out.println("Data de hoje: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());
    }

    public static void menu() {
        opcoes();
        int opt = SafeInput.SafeRangeInt(1, 7);
        switch (opt) {
            case 1:
                try {
                    System.out.println(UsuarioController.listarUsuarios());
                } catch (Exception _) {
                    System.err.println("Não foi possível listar os usuários");
                }
                break;
            case 2:
                try {
                    for (var livro : LivroController.listarLivros()) {
                        String sb = livro.titulo + " - " + livro.autor + "\n" +
                                "\t - ID: " + livro.id + "\n" +
                                "\t - ISBN: " + livro.isbn + "\n" +
                                "\t - Qntd: " + livro.quantidade + "\n";
                        System.out.println(sb);
                    }
                } catch (Exception _) {
                    System.err.println("Não foi possível listar os usuários");
                }
                break;
            case 3:
                System.out.println("Digite o título do livro: ");
                String titulo = SafeInput.SafeString();
                System.out.println("Digite o nome do autor: ");
                String autor = SafeInput.SafeString();
                System.out.println("Digite a quantidade de livros a adicionar: ");
                int quantidade = SafeInput.SafeRangeInt(1, 1000);
                String isbn = String.valueOf((autor.hashCode() + titulo.hashCode())).toLowerCase();
                try {
                    System.out.println("Novo livro registrado ID: " + LivroController.criarLivro(new Random().nextInt(100000), titulo, autor, isbn, quantidade).id);
                } catch (Exception _) {
                    System.err.println("Este livro já existe no sistema");
                }
                break;
            case 4:
                System.out.println("Digite o tipo do usuário: ");
                System.out.println("\t1 - Aluno");
                System.out.println("\t2 - Professor");
                int tipo = SafeInput.SafeRangeInt(1, 2);
                System.out.println("Digite o nome do usuário: ");
                String nome = SafeInput.SafeString();
                try {
                    System.out.println("Novo usuário registrado Nº de Registro: " + UsuarioController.criarContaDeUsuario(tipo, nome).numDeRegistro);
                } catch (Exception _) {
                    System.err.println("Não foi possível registrar o usuário");
                }
                break;
            case 5:
                System.out.println("Digite o ID do usuário: ");
                String idUsr = SafeInput.SafeString();
                System.out.println("Digite a operação: ");
                System.out.println("\t1 - Emprestar");
                System.out.println("\t2 - Devolver");
                int tipoOp = SafeInput.SafeRangeInt(1, 2);
                System.out.println("Digite o id do livro");
                int idLivro = SafeInput.SafeInt();
                if (tipoOp == 1) {
                    LocalDateTime newDate = date.plusDays(14);
                    String entrega = (newDate.getDayOfMonth() + "/" + newDate.getMonthValue() + "/" + newDate.getYear());
                    try {
                        boolean emprestado = BibliotecaController.emprestarLivro(idUsr, idLivro);
                        System.out.println(emprestado ? "O livro foi emprestado com sucesso\nData de entrega: " + entrega : "Não há mais livros disponíveis");
                    } catch (Exception e){
                        System.err.println("Não foi possível emprestar o livro " + e.getMessage());
                        e.printStackTrace();
                    }
                }


        }
    }
}
