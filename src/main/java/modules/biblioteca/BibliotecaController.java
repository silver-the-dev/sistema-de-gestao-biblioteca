package modules.biblioteca;

import modules.livro.LivroController;
import modules.livro.LivroModel;
import modules.livro.LivroRepository;
import modules.livro.LivroService;
import modules.usuario.UsuarioRepository;
import modules.usuario.models.Usuario;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaController {
    public static boolean emprestarLivro(String numDeReg, int idLivro, LocalDateTime newDate) throws Exception {
        return BibliotecaService.emprestarLivro(numDeReg, idLivro, newDate);
    }

    public static boolean devolverLivro(String idUsr, int idLivro) throws IOException{
        return BibliotecaService.devolverLivro(idUsr, idLivro);
    }

    public static String verificarEmprestimos() throws IOException {
        ArrayList<Emprestimo> emprestimos = BibliotecaService.verificarEmprestimos();
        ArrayList<Usuario> usrs = UsuarioRepository.listarUsuarios();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> idsJaListados = new ArrayList<>();

        for(var user : emprestimos){
            List<Emprestimo> livrosDoUsuario = emprestimos.stream().filter(l -> l.idUsr.equals(user.idUsr)).toList();
            if(!livrosDoUsuario.isEmpty() && !idsJaListados.contains(user.idUsr)){
                sb.append("Usuário ").append(user.idUsr);
                sb.append("\n").append("\tLivros:");
                for(var livro : livrosDoUsuario){
                    LivroModel lvr = LivroController.listarLivros().stream().filter(l -> l.id == livro.idLivro).findFirst().orElseThrow();
                    sb.append("\n\t\t").append(lvr.titulo).append(" - ").append(lvr.id);
                }
                sb.append("\n");
            }
            idsJaListados.add(user.idUsr);
        }
        return sb.toString();
    }
}
