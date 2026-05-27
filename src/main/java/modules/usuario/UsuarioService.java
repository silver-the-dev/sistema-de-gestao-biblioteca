package modules.usuario;

import modules.usuario.models.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class UsuarioService {
    public static boolean emprestarLivro(Usuario usr, int idDoLivro){
        for (int i = 0; i < usr.limiteDeLivros; i++) {
            if(usr.idsLivrosEmprestados[i] <= 0){
                usr.idsLivrosEmprestados[i] = idDoLivro;
                return true;
            }
        }
        return false;
    }

    public static Usuario criarContaDeUsuario(int tipo, String numDeRegistro, String nome) throws IOException {
        return UsuarioRepository.criarContaDeUsuario(tipo, numDeRegistro, nome);
    }

    public static ArrayList<Usuario> listarUsuarios() throws IOException {
        return UsuarioRepository.listarUsuarios();
    }
}
