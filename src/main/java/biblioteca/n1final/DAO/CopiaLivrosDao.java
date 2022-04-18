package biblioteca.n1final.DAO;
import biblioteca.n1final.model.CopiaLivro;
import biblioteca.n1final.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class CopiaLivrosDao {

    Livro livro;
    private List<CopiaLivro> copias = new ArrayList<CopiaLivro>();

    public CopiaLivrosDao(Livro livro){
        this.livro = livro;

        CopiaLivro copiaFixa = new CopiaLivro(livro, true);
        copias.add(copiaFixa);
    }

    public void setNumCopias (int numCopias){

        int counter = 1;

        if(numCopias >= 2){
            while(counter < numCopias){
                System.out.print("here");
                CopiaLivro copiaLivro = new CopiaLivro(livro, false);
                copias.add(copiaLivro);
                counter++;
            }
        }
    }

    public List listar(){
        return copias;
    }

    public void adicionarCopia(){
        CopiaLivro novaCopia = new CopiaLivro(livro, false);
        copias.add(novaCopia);
    }

    public void removerCopia(){
        if((copias.size()-1) > 1){
            copias.remove(copias.get(copias.size()-1));
        }

    }

}
