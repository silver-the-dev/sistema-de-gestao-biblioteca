package modules.usuario;

import modules.usuario.models.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class UsuarioController {
    public static Usuario criarContaDeUsuario(int tipo, String nome) throws IOException {
        int numDeRegistro = new Random(System.currentTimeMillis()).nextInt(10000, 99999);
        return UsuarioService.criarContaDeUsuario(tipo, Integer.toString(numDeRegistro), nome);
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
