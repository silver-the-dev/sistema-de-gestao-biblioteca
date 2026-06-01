package modules.biblioteca;

import modules.livro.LivroModel;
import modules.livro.LivroRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BibliotecaRepository {

    public static ArrayList<Emprestimo> emprestimosAtualizados = new ArrayList<>();

    public static boolean emprestarLivro(String idUsr, int idLivro, LocalDateTime newDate) throws IOException {
        LivroModel l = LivroRepository.listarLivros().stream().filter(li -> idLivro == li.id).findFirst().orElseThrow();
        LivroRepository.modificarQuantidade(l, l.quantidade -= 1);
        emprestimosAtualizados.add(new Emprestimo(idUsr, idLivro, newDate));
        FileWriter fw = new FileWriter("emprestimos.csv", true);
        fw.write(idUsr + "," + idLivro + "," + newDate.toString() + "\n");
        fw.close();
        return true;
    }
    public static boolean devolverLivro(String idUsr, int idLivro) throws IOException{
        LivroModel l = LivroRepository.listarLivros().stream().filter(li -> idLivro == li.id).findFirst().orElseThrow();
        LivroRepository.modificarQuantidade(l, l.quantidade += 1);
        emprestimosAtualizados.removeIf(li -> li.idLivro == idLivro && li.idUsr.equals(idUsr));
        BufferedReader bf = new BufferedReader(new FileReader("emprestimos.csv"));
        File original = new File("emprestimos.csv");
        File temp = new File("temp.csv");
        FileWriter fw = new FileWriter(temp);
        String line;
        int linha = 1;

        while((line = bf.readLine()) != null){
            String[] emprestimo = line.split(",");
            if(emprestimo[0].equals(idUsr) && Integer.parseInt(emprestimo[1]) == idLivro){
                continue;
            } else {
                fw.write(line + "\n");
            }
        }
        fw.close();

        if(original.delete()){
            temp.renameTo(original);
        }
        return true;
    }

    public static ArrayList<Emprestimo> verificarEmprestimos() throws IOException{
        if(!emprestimosAtualizados.isEmpty()){
            return emprestimosAtualizados;
        }
        BufferedReader bf = new BufferedReader(new FileReader("emprestimos.csv"));
        String line;
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        while((line = bf.readLine()) != null){
            String[] emprestimo = line.split(",");
            emprestimos.add(new Emprestimo(emprestimo[0], Integer.parseInt(emprestimo[1]), LocalDateTime.parse(emprestimo[2])));
        }
        return emprestimos;
    }
}
