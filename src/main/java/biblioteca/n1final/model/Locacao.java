package biblioteca.n1final.model;

public class Locacao {

    CopiaLivro copiaLivro;
    int idLocacao;
    int idLocatario;

    Locacao(CopiaLivro copiaLivro, Aluno aluno){
        this.copiaLivro = copiaLivro;
        this.idLocatario = aluno.id;
    }

    Locacao(CopiaLivro copiaLivro, Professor professor){
        this.copiaLivro = copiaLivro;
        this.idLocatario = professor.id;
        this.idLocacao = this.hashCode();
    }
}
