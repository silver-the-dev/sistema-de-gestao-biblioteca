package modules.livro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    public static LivroModel criarLivro(int id, String titulo, String autor, String isbn, int quantidade) throws IOException {
        List<String> listaDeISBNs = listarLivros().stream().map(LivroModel::isbn).toList();
        isbn = String.valueOf(Math.abs(Integer.parseInt(isbn)));
        FileWriter fw = new FileWriter("livros.csv", true);
        if(listaDeISBNs.contains(isbn)){
            return null;
        }
        fw.write(id + "," + titulo + "," + autor + "," + isbn + "," + quantidade + "\n");
        fw.close();
        return new LivroModel(id, titulo, autor, isbn, quantidade);
    }
    public static ArrayList<LivroModel> listarLivros() throws IOException{
        ArrayList<LivroModel> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("livros.csv"));
        String line;
        while((line = br.readLine()) != null){
            String[] livro = line.split(",");
            lista.add(new LivroModel(Integer.parseInt(livro[0]), livro[1], livro[2], livro[3], Integer.parseInt(livro[4])));
        }
        br.close();
        return lista;
    }
}
