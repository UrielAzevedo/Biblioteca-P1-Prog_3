package biblioteca.n1final.model;

public class Autor {
    String nome;
    String sobrenome;
    int id;

    Autor(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.id = this.hashCode();
    }

    public Autor(){
        this.id = this.hashCode();
    }

    public String getNome(){
        return (this.nome);
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return (this.sobrenome);
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", id=" + id +
                '}';
    }
}
