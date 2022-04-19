package biblioteca.n1final.DAO;

import biblioteca.n1final.model.Locacao;

import java.util.ArrayList;
import java.util.List;

public class LocacaoDao implements DAO<Locacao>{

    private static List<Locacao> locacoes = new ArrayList<Locacao>();

    @Override
    public void gravar(Locacao locacao) throws Exception {
        locacoes.add(locacao);
    }

    @Override
    public List<Locacao> listar() throws Exception {
        return locacoes;
    }

    @Override
    public void excluir(Locacao locacao) throws Exception {
        locacoes.remove(locacao);
    }

}
