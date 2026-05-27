package modules.usuario;

import modules.usuario.models.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class UsuarioController {
    public static Usuario criarContaDeUsuario(int tipo, String numDeRegistro, String nome) throws IOException {
        return UsuarioService.criarContaDeUsuario(tipo, numDeRegistro, nome);
    }

    public static String listarUsuarios() throws IOException{
        ArrayList<Usuario> usuarios = UsuarioService.listarUsuarios();
        StringBuilder sb = new StringBuilder();
        usuarios.forEach((u) -> sb.append("Usuário " + u.numDeRegistro + "\n" +
                                                  "\t- Nome: " + u.nome + "\n" +
                                                  "\t- Tipo: " + (u.limiteDeLivros == 3 ? "Aluno" : "Professor") + "\n"));
        return sb.toString();
    }
}
