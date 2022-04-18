package biblioteca.n1final.DAO;

import biblioteca.n1final.model.Autor;
import biblioteca.n1final.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class AutoresDao implements DAO<Autor>{

    int id;
    private static List<Autor> autores = new ArrayList<Autor>();

    public AutoresDao(){
        this.id = hashCode();
    }

    @Override
    public void gravar(Autor autor){
        autores.add(autor);
    }

    @Override
    public List listar(){
        return autores;
    }

    @Override
    public void excluir(Autor autor){
        autores.remove(autor);
    }
}
