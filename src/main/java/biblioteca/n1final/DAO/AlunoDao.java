package biblioteca.n1final.DAO;

import biblioteca.n1final.model.Aluno;
import biblioteca.n1final.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements DAO<Aluno>{

    private static List<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public void gravar(Aluno aluno) throws Exception {
        alunos.add(aluno);
    }

    @Override
    public List listar() throws Exception {
        return alunos;
    }

    @Override
    public void excluir(Aluno aluno) throws Exception {
        alunos.remove(aluno);
    }
}
