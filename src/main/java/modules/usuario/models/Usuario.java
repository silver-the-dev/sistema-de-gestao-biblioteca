package modules.usuario.models;

public abstract class Usuario {
    protected String numDeRegistro;
    protected String nome;
    protected int limiteDeLivros;
    protected int[] idsLivrosEmprestados;

    public Usuario(String numDeRegistro, String nome, int limiteDeLivros, int[] idsLivrosEmprestados){
        this.numDeRegistro = numDeRegistro;
        this.nome = nome;
        this.limiteDeLivros = limiteDeLivros;
        this.idsLivrosEmprestados = idsLivrosEmprestados;
    }
}
