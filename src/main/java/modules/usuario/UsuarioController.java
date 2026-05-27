package modules.usuario;

import modules.usuario.models.Usuario;

import java.util.ArrayList;
import java.util.Optional;

public class UsuarioController {
    public static Optional<Usuario> criarContaDeUsuario(int tipo, String numDeRegistro, String nome){
        try{
            return Optional.of(UsuarioService.criarContaDeUsuario(tipo, numDeRegistro, nome));
        } catch (Exception e){
            System.err.println("Erro ao criar conta de usuário");
        }
        return Optional.empty();
    }

    public static void listarUsuarios() {
//        ArrayList<Usuario> usuarios = UsuarioService.listarUsuarios();
    }
}
