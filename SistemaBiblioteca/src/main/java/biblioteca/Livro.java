
package biblioteca;


public class Livro {
  private String titulo;
  private String autores;
  private String editora;
  private int edicao,ano,paginas,quantidade;
 

    public Livro(String titulo, String autores, String editora, int edicao, int ano, int paginas, int quantidade) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
        this.paginas = paginas;
        this.quantidade = quantidade;
       
    }
  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
