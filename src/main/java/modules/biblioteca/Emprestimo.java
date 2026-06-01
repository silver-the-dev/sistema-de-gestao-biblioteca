package modules.biblioteca;

import java.time.LocalDateTime;

public class Emprestimo {
    public String idUsr;
    public int idLivro;
    public LocalDateTime dateToDeliver;

    public Emprestimo(String idUsr, int idLivro, LocalDateTime dateToDeliver){
        this.idUsr = idUsr;
        this.idLivro = idLivro;
        this.dateToDeliver = dateToDeliver;
    }
}
