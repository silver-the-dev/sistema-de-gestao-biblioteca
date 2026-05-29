package modules.biblioteca;

import java.io.FileWriter;
import java.io.IOException;

public class BibliotecaRepository {

    public static boolean emprestarLivro(String idUsr, int idLivro) throws IOException {
        FileWriter fw = new FileWriter("emprestimos.csv", true);
        fw.write(idUsr + "," + idLivro + "\n");
        fw.close();
        return true;
    }
}
