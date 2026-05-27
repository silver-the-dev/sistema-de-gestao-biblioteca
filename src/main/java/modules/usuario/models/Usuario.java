package modules.usuario.models;

public abstract class Usuario {
    public String numDeRegistro;
    public String nome;
    public int limiteDeLivros;
    public int[] idsLivrosEmprestados;

    public Usuario(String numDeRegistro, String nome, int limiteDeLivros, int[] idsLivrosEmprestados){
        this.numDeRegistro = numDeRegistro;
        this.nome = nome;
        this.limiteDeLivros = limiteDeLivros;
        this.idsLivrosEmprestados = idsLivrosEmprestados;
    }
}
