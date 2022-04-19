package biblioteca.n1final.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    int id;
    String nome;
    List<Locacao> locacoes = new ArrayList<Locacao>();

    public int getId() {
        return id;
    }

    public Professor(String nome){
        this.nome = nome;
        this.id = this.hashCode();
    }

    public Professor(){
        this.id = this.hashCode();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void adicionarLocacao (Locacao locacao){
        this.locacoes.add(locacao);
    }

    public void removerLocacao (Locacao locacao){
        this.locacoes.remove(locacao);
    }

    public List<Locacao> getLocacoes () {
        return locacoes;
    }
}
