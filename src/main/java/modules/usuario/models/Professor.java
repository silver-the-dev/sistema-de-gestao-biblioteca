package modules.usuario.models;

public class Professor extends Usuario{
    public Professor(String numDeRegistro, String nome) {
        super(numDeRegistro, nome, 5, new int[5]);
    }
}
