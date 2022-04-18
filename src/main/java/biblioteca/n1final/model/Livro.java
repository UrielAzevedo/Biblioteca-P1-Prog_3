package biblioteca.n1final.model;

import biblioteca.n1final.DAO.AutoresDao;
import biblioteca.n1final.DAO.CopiaLivrosDao;
import biblioteca.n1final.DAO.DAO;
import biblioteca.n1final.DAO.LivroDao;

import java.util.ArrayList;
import java.util.List;

public class Livro{
    private String nome;
    private GeneroLivros genero;
    private String edicao;
    private String ano;
//    private AutoresDao daoAutores = new AutoresDao();
    private List<Autor> autores = new ArrayList();
//    private List<CopiaLivro> copias = new ArrayList();
    private CopiaLivrosDao daoCopias = new CopiaLivrosDao(this);

    Livro(String nome, GeneroLivros genero, String edicao, String ano) {
        this.nome = nome;
        this.genero = genero;
        this.edicao = edicao;
        this.ano = ano;
        this.daoCopias = new CopiaLivrosDao(this);
    }

    public Livro(){

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroLivros getGenero() {
        return this.genero;
    }

    public void setGenero(GeneroLivros genero) {
        this.genero = genero;
    }

    public String getEdicao() {
        return this.edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public List<CopiaLivro> getCopias() {
        return daoCopias.listar();
    }

    public void setCopias(int numCopias) {
        this.daoCopias.setNumCopias(numCopias);
    }

    public void adicionarCopia() {
        daoCopias.adicionarCopia();
    }

    public void excluirCopia() {
        daoCopias.removerCopia();
    }

    public List getAutores() {
        return autores;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void excluirAutor(Autor autor) {
        autores.remove(autor);
    }

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

//    public void setNumCopias (int numCopias){
//
//        int counter = 0;
//
//        if(numCopias >= 1){
//
//            CopiaLivro copiaLivro = new CopiaLivro(this, true);
//            getCopias().add(copiaLivro);
//            counter++;
//
//            while(counter < numCopias){
//                copiaLivro = new CopiaLivro(this, false);
//                counter++;
//            }
//
//            counter = 0;
//        }else{
//
//            CopiaLivro copiaLivro = new CopiaLivro(this, true);
//            getCopias().add(copiaLivro);
//
//        }
//    }
//
//    public void adicionarCopia(){
//        CopiaLivro novaCopia = new CopiaLivro(this, false);
//        copias.add(novaCopia);
//    }
//
//    public void removerCopia(){
//        if(copias.size()-1 > 1){
//            copias.remove(copias.get(copias.size()-1));
//        }
//
//    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                ", edicao='" + edicao + '\'' +
                ", ano='" + ano + '\'' +
                ", autores=" + autores +
                ", copias=" + daoCopias.listar() +
                '}';
    }
}

