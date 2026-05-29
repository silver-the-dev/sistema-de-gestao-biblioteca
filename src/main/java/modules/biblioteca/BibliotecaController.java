package modules.biblioteca;

import modules.livro.LivroModel;
import modules.usuario.models.Usuario;

public class BibliotecaController {
    public static boolean emprestarLivro(String numDeReg, int idLivro) throws Exception {
        return BibliotecaService.emprestarLivro(numDeReg, idLivro);
    }
}
