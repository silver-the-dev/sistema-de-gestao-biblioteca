package modules.biblioteca;

import modules.livro.LivroModel;
import modules.usuario.models.Usuario;

public class BibliotecaController {
    public static boolean emprestarLivro(Usuario usr, LivroModel livro){
        return BibliotecaService.emprestarLivro(usr, livro.id());
    }
}
