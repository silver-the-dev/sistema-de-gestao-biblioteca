package modules.biblioteca;

import modules.livro.LivroModel;
import modules.livro.LivroRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BibliotecaRepository {

    public static Map<String, Integer> emprestimosAtualizados = new HashMap<>();

    public static boolean emprestarLivro(String idUsr, int idLivro) throws IOException {
        LivroModel l = LivroRepository.listarLivros().stream().filter(li -> idLivro == li.id).findFirst().orElseThrow();
        LivroRepository.modificarQuantidade(l, l.quantidade-=1);
        emprestimosAtualizados.put(idUsr, idLivro);
        FileWriter fw = new FileWriter("emprestimos.csv", true);
        fw.write(idUsr + "," + idLivro + "\n");
        fw.close();
        return true;
    }

    public static Map<String, Integer> verificarEmprestimos() throws IOException{
        if(!emprestimosAtualizados.isEmpty()){
            return emprestimosAtualizados;
        }
        BufferedReader bf = new BufferedReader(new FileReader("emprestimos.csv"));
        String line;
        Map<String, Integer> mk = new HashMap<>();
        while((line = bf.readLine()) != null){
            String[] emprestimo = line.split(",");
            mk.put(emprestimo[0], Integer.parseInt(emprestimo[1]));
        }
        return mk;
    }
}
