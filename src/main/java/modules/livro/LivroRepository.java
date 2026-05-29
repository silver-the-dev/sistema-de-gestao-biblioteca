package modules.livro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    public static ArrayList<LivroModel> livrosDisponiveis = new ArrayList<>();

    public static LivroModel criarLivro(int id, String titulo, String autor, String isbn, int quantidade) throws IOException {
        LivroModel livro = new LivroModel(id, titulo, autor, isbn, quantidade);
        livrosDisponiveis.add(livro);
        List<String> listaDeISBNs = listarLivros().stream().map(l -> l.isbn).toList();
        isbn = String.valueOf(Math.abs(Integer.parseInt(isbn)));
        FileWriter fw = new FileWriter("livros.csv", true);
        if(listaDeISBNs.contains(isbn)){
            return null;
        }
        fw.write(id + "," + titulo + "," + autor + "," + isbn + "," + quantidade + "\n");
        fw.close();
        return livro;
    }
    public static ArrayList<LivroModel> listarLivros() throws IOException{
        if(!livrosDisponiveis.isEmpty()){
            return livrosDisponiveis;
        }
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

    public static boolean modificarQuantidade(LivroModel livroModel, int quantidadeNova) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader("livros.csv"));
        File original = new File("livros.csv");
        File temp = new File("temp.csv");
        FileWriter fw = new FileWriter(temp);
        String line;
        int linha = 1;

        while((line = bf.readLine()) != null){
            String[] livro = line.split(",");
            if(Integer.parseInt(livro[0]) == livroModel.id){
                fw.write(livroModel.id + "," + livroModel.titulo + "," + livroModel.autor + "," + livroModel.isbn + "," + quantidadeNova + "\n");
            } else {
                fw.write(line + "\n");
            }
        }
        livrosDisponiveis.stream().filter(l -> livroModel.id == l.id).findFirst().ifPresent(l -> l.setQuantidade(quantidadeNova));
        if(original.delete()){
            temp.renameTo(original);
        }
        fw.close();
        return true;
    }
}
