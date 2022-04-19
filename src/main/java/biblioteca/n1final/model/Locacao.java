package biblioteca.n1final.model;

public class Locacao {

    CopiaLivro copiaLivro;
    int idLocacao;
    boolean professor;
    int idLocatario;
    int prazo;
    int diasDecorridos;

    Locacao(CopiaLivro copiaLivro, Aluno aluno){
        this.copiaLivro = copiaLivro;
        this.idLocatario = aluno.id;
    }

    Locacao(CopiaLivro copiaLivro, Professor professor){
        this.copiaLivro = copiaLivro;
        this.idLocatario = professor.id;
        this.idLocacao = this.hashCode();
    }

    public Locacao(){

    }

    public boolean isProfessor() {
        return professor;
    }

    public void setProfessor(boolean professor) {
        this.professor = professor;
    }

    public int getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(int idLocatario) {
        this.idLocatario = idLocatario;
    }

    public void setCopiaLivro (CopiaLivro copiaLivro) {
        this.copiaLivro = copiaLivro;
    }

    public CopiaLivro getCopiaLivro (){
        return copiaLivro;
    }

    public void setPrazo (int prazo){
        this.prazo = prazo;
    }

    public int getPrazo (){
        return prazo;
    }

    public int getDiasDecorridos() {
        return diasDecorridos;
    }

    public void setDiasDecorridos(int diasDecorridos) {
        this.diasDecorridos = diasDecorridos;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "copiaLivro=" + copiaLivro +
                ", idLocacao=" + idLocacao +
                ", professor=" + professor +
                ", idLocatario=" + idLocatario +
                ", prazo=" + prazo +
                ", diasDecorridos=" + diasDecorridos +
                '}';
    }
}
