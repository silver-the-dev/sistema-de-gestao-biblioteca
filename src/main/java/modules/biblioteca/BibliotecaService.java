package modules.biblioteca;

import modules.usuario.UsuarioService;
import modules.usuario.models.Usuario;

public class BibliotecaService {
    public static boolean emprestarLivro(Usuario usr, int id) {
        return UsuarioService.emprestarLivro(usr, id);
    }
}
