package modules.usuario;

import modules.usuario.models.Aluno;
import modules.usuario.models.Professor;
import modules.usuario.models.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioRepository {

    public static Usuario criarContaDeUsuario(int tipo, String numDeRegistro, String nome) throws IOException {
        FileWriter fw = new FileWriter("usuarios.csv", true);
        fw.write(numDeRegistro + "," + nome + "," + tipo + "\n");
        fw.close();
        return tipo == 1 ? new Aluno(numDeRegistro, nome) : new Professor(numDeRegistro, nome);
    }

    public static ArrayList<Usuario> listarUsuarios() throws IOException {
        String line;
        BufferedReader bf = new BufferedReader(new FileReader("usuarios.csv"));
        while((line = bf.readLine()) != null){
            String[] usuario = line.split(",");

        }
        bf.close();
    }
}
