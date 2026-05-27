package shared;

import modules.biblioteca.BibliotecaController;
import modules.livro.LivroController;
import modules.usuario.UsuarioController;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    public static void opcoes(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.println("Menu de Opções: ");
        System.out.println("\t1 - Listar Todos os Usuários");
        System.out.println("\t2 - Listar Todos os Livros");
        System.out.println("\t3 - Criar um Novo Livro");
        System.out.println("\t4 - Criar um Novo Usuário");
        System.out.println("\t6 - Emprestar/Devolver um Livro");
        System.out.println("\t7 - Ver Livros em Atraso");
        System.out.println("Data de hoje: " + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear());
    }

    public static void menu(){
        opcoes();
        int opt = SafeInput.SafeRangeInt(1, 7);
        try {
            switch (opt){
                case 1:
                    System.out.println(UsuarioController.listarUsuarios());
                    break;
                case 2:
                    LivroController.listarLivros();
                    break;
                case 3:
                    LivroController.criarLivro();
                    break;
                case 4:
                    System.out.println("Digite o tipo do usuário: ");
                    System.out.println("\t1 - Aluno");
                    System.out.println("\t2 - Professor");
                    int tipo = SafeInput.SafeRangeInt(1, 2);
                    System.out.println("Digite o número de registro: ");
                    String numDeRegistro = SafeInput.SafeString();
                    System.out.println("Digite o nome do usuário: ");
                    String nome = SafeInput.SafeString();
                    UsuarioController.criarContaDeUsuario(tipo, numDeRegistro, nome);
                    break;
            }
        } catch (Exception e){
            System.err.println("Não foi possível realizar esta operação");
        }
    }
}
