package modules.livro;

import java.io.IOException;
import java.util.ArrayList;

public class LivroService {
    public static LivroModel criarLivro(int id, String titulo, String autor, String isbn, int quantidade) throws IOException {
        return LivroRepository.criarLivro(id, titulo, autor, isbn, quantidade);
    }

    public static ArrayList<LivroModel> listarLivros() throws IOException {
        return LivroRepository.listarLivros();
    }
}
