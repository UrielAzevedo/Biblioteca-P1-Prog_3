package biblioteca.n1final.DAO;
import biblioteca.n1final.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDao implements DAO<Livro>{

    private static List<Livro> livros = new ArrayList<Livro>();

    @Override
    public void gravar(Livro object) throws Exception {
        livros.add(object);
    }

    @Override
    public List listar() throws Exception {
        return livros;
    }

    @Override
    public void excluir(Livro object) throws Exception {
        livros.remove(object);
    }
}
