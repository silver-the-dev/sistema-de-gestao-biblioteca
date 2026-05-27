package modules.livro;

import java.io.IOException;
import java.util.ArrayList;

public class LivroController {
    public static ArrayList<LivroModel> listarLivros() throws IOException{
        return LivroService.listarLivros();
    }

    public static LivroModel criarLivro(int id, String titulo, String autor, String isbn, int quantidade) throws IOException {
        return LivroService.criarLivro(id, titulo, autor, isbn, quantidade);
    }
}
