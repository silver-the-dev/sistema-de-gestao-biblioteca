package modules.biblioteca;

import modules.livro.LivroModel;
import modules.livro.LivroRepository;
import modules.usuario.UsuarioRepository;
import modules.usuario.UsuarioService;
import modules.usuario.models.Usuario;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class BibliotecaService {
    public static boolean emprestarLivro(String usr, int id, LocalDateTime newDate) throws Exception {
        Usuario usuario = UsuarioRepository.listarUsuarios().stream().filter(u -> u.numDeRegistro.equals(usr)).findAny().orElseThrow();
        LivroModel livro = LivroRepository.listarLivros().stream().filter(l -> l.id == id).findFirst().orElseThrow();
        if(livro.quantidade > 0){
            UsuarioService.emprestarLivro(usuario, livro.id);
            return BibliotecaRepository.emprestarLivro(usr, id, newDate);
        }
        return false;
    }

    public static boolean devolverLivro(String idUsr, int idLivro) throws IOException{

        return BibliotecaRepository.devolverLivro(idUsr, idLivro);
    }

    public static ArrayList<Emprestimo> verificarEmprestimos() throws IOException {
        return BibliotecaRepository.verificarEmprestimos();
    }
}
