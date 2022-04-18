package biblioteca.n1final.model;

public class Professor {

    int id;
    String nome;

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
}
