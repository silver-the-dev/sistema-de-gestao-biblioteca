package modules.usuario;

import modules.usuario.models.Aluno;
import modules.usuario.models.Professor;
import modules.usuario.models.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public static Usuario criarContaDeUsuario(int tipo, String numDeRegistro, String nome) throws IOException {
        List<String> idsRegistrados = listarUsuarios().stream().map(Usuario::getNumDeRegistro).toList();
        int n = Integer.parseInt(numDeRegistro);
        while(idsRegistrados.contains(Integer.toString(n))){
            n++;
        }
        numDeRegistro = Integer.toString(n);
        FileWriter fw = new FileWriter("usuarios.csv", true);
        fw.write(numDeRegistro + "," + nome + "," + tipo + "\n");
        fw.close();
        return tipo == 1 ? new Aluno(numDeRegistro, nome) : new Professor(numDeRegistro, nome);
    }

    public static ArrayList<Usuario> listarUsuarios() throws IOException {
        String line;
        BufferedReader bf = new BufferedReader(new FileReader("usuarios.csv"));
        ArrayList<Usuario> usr = new ArrayList<>();
        while((line = bf.readLine()) != null){
            String[] usuario = line.split(",");
            if(usuario[2].equals("1")){
                usr.add(new Aluno(usuario[0], usuario[1]));
            } else{
                usr.add(new Professor(usuario[0], usuario[1]));
            }
        }
        bf.close();
        return usr;
    }
}
