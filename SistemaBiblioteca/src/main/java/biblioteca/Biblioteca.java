

package biblioteca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
      
         try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
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
          try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
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
    public String procurarExclusao(String titulo, String autor){
          StringBuilder string = new StringBuilder();
          try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
             String linha;
             //enquanto o arquivo tiver linha ele vai ler
             while((linha = ler.readLine())!= null){
                 //conferir se titulo e autor esta na linha se tiver vai retornar essa linha
                 //essa linha deve aparecer no textArea modificada para o usuario n digitar nela.
                 if(linha.toLowerCase().contains(titulo.toLowerCase()) && 
                         linha.toLowerCase().contains(autor.toLowerCase()) ){
                    ler.close(); 
                     string.append(linha).append("\n");
                   return string.toString();
                 }else{
                     ler.close();
             string.append("livro nao encontrado.");
            return string.toString();
                 }             
              }
             // acho que e bom colocar outro catch caso o arquivo nao seja excluido ou so usar if mesmo.
          } catch(IOException e){
         System.out.println("nao foi possivel acessar o arquivo"+ e.getMessage());
     }
        return null;
    
    }
    public int excluirLivro(String apagar){
       
        File temp = new File("temp.txt");
       try(
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(temp));
           ){
            String linha;

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
                System.out.println(apagar);
                // Ignora a linha com o conteúdo exato
                if (!linha.trim().equals(apagar.trim())) {
                    escritor.write(linha);
                    escritor.newLine();
                }
            }
         }catch(IOException e){
             
             System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
             return 0;
         }
            // Substitui o arquivo original pelo temporário
           if( arquivo.delete())
            temp.renameTo(arquivo);
            

            System.out.println("Linha removida com sucesso.");
            return 1;
        }
       
    }

    

