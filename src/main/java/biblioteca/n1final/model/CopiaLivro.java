package biblioteca.n1final.model;

public class CopiaLivro {
    int id;
    Livro livro;
    boolean copiaFixa;
    boolean locada;

    public CopiaLivro(Livro livro, boolean copiaFixa) {
        this.livro = livro;
        this.copiaFixa = copiaFixa;
        this.id = this.hashCode();
        this.locada = false;
    }

    public CopiaLivro(){
        this.id = hashCode();
        this.copiaFixa = false;
    }

    @Override
    public String toString() {
        return "CopiaLivro{" +
                "id=" + id +
                ", livro=" + livro.getNome() +
                ", copiaFixa=" + copiaFixa +
                ", locada=" + locada +
                '}';
    }

    public void setLocada(boolean estadoLocacao){
        this.locada = estadoLocacao;
    }

    public boolean getLocada(){
        return locada;
    }

    public boolean getCopiaFixa(){
        return copiaFixa;
    }
}
