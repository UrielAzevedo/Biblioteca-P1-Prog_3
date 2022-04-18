package biblioteca.n1final.model;

public class CopiaLivro {
    int id;
    Livro livro;
    boolean copiaFixa;

    public CopiaLivro(Livro livro, boolean copiaFixa) {
        this.livro = livro;
        this.copiaFixa = copiaFixa;
        this.id = this.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", livro=" + livro.getNome() +
                ", copiaFixa=" + copiaFixa +
                '}';
    }
}
