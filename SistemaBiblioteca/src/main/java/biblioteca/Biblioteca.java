

package biblioteca;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private static String pasta = "SistemaBiblioteca.txt";
    File arquivo = new File(pasta);
    
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
    
    
    public void inclusaoDeLivro(String titulo, String autor,String editora,int edicao,int ano,
           int paginas, int quantidade){
       
         try (FileWriter file = new FileWriter(arquivo, true)) {
             file.write("Titulo:"+titulo+"| Autor:"+autor+"| Editora:"+editora+"| Edicao:"+edicao+"| Ano:"+ano+"| Paginas:"
                     +paginas+"| Quntidade"+quantidade+"\n");
         }catch(IOException e){
                 System.out.println("erro ao salvar:"+ e.getMessage());
           }
    }
    public String listagemDeLivro(){
      StringBuilder string = new StringBuilder();
      
         try (BufferedReader ler = new BufferedReader(new FileReader(pasta))) {
             String linha;
             while((linha = ler.readLine())!= null){
                string.append(linha).append("\n");
             }} catch(IOException e){
         System.out.println("nao foi possivel acessar o arquivo"+ e.getMessage());
     }
        return string.toString();
    }
     
    public String consultaDeLivro(String titulo){
         StringBuilder string = new StringBuilder();
          try (BufferedReader ler = new BufferedReader(new FileReader(pasta))) {
             String linha;
             while((linha = ler.readLine())!= null){
                 if(linha.toLowerCase().contains(titulo.toLowerCase())){
                    ler.close();
                     string.append(linha).append("\n");
                     return string.toString();
                 }
               
             }
             ler.close();
             string.append("livro nao encontrado.");
             return string.toString();
          } catch(IOException e){
         System.out.println("nao foi possivel acessar o arquivo"+ e.getMessage());
     }
        return null;
    }
    public void alteracaoDeLivro(){
    
    }
    public void exclusaoDeLivro(){
    
    }

    
}
