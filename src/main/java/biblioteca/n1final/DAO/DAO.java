package biblioteca.n1final.DAO;
import java.util.List;

public interface DAO<T> {

    public void gravar(T object) throws Exception;
    public List<T> listar() throws Exception;
    public void excluir(T object) throws Exception;

}
