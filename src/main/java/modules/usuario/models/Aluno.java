package modules.usuario.models;

public class Aluno extends Usuario {
    public Aluno(String numDeRegistro, String nome) {
        super(numDeRegistro, nome, 3, new int[3]);
    }
}
