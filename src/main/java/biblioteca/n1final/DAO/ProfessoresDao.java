package biblioteca.n1final.DAO;

import biblioteca.n1final.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessoresDao implements DAO<Professor>{

    public static List<Professor> professores = new ArrayList<Professor>();

    @Override
    public void gravar(Professor professor) throws Exception {
        professores.add(professor);
    }

    @Override
    public List<Professor> listar() throws Exception {
        return professores;
    }

    @Override
    public void excluir(Professor professor) throws Exception {
        professores.remove(professor);
    }
}
