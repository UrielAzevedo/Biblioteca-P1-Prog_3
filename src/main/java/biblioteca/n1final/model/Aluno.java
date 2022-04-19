package biblioteca.n1final.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    String nome;
    int id;
    List<Locacao> locacoes = new ArrayList<Locacao>();

    public Aluno(String nome){
        this.nome = nome;
        this.id = this.hashCode();
    }

    public Aluno(){
        this.id = this.hashCode();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
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

