package modules.livro;

public class LivroModel {
    public int id;
    public String titulo;
    public String autor;
    public String isbn;
    public int quantidade;

    public LivroModel(int id, String titulo, String autor, String isbn, int quantidade){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
