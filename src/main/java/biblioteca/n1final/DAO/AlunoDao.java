package biblioteca.n1final.DAO;

import biblioteca.n1final.model.Aluno;
import biblioteca.n1final.model.Livro;
import biblioteca.n1final.model.Professor;

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

    public Aluno getAluno(int id){

        for(Aluno aluno : alunos){
            if(aluno.getId() == id){
                return aluno;
            }
        }

        return null;
    }
}
