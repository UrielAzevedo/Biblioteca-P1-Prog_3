package biblioteca.n1final.model;

public class Aluno {
    String nome;
    int id;

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

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}

