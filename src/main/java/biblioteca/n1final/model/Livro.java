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
    private List<Autor> autores = new ArrayList();
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

    public CopiaLivro copiaDisponivelLocacao () {

        for(CopiaLivro copia : getCopias()){
            if(!copia.getLocada() && !copia.getCopiaFixa()){
                return copia;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                ", edicao='" + edicao + '\'' +
                ", ano='" + ano + '\'' +
                ", autores=" + autores +
                ", Copias=" + daoCopias.listar().size() +
                '}';
    }
}

