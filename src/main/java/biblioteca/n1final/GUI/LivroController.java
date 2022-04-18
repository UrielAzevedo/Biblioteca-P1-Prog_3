package biblioteca.n1final.GUI;

import biblioteca.n1final.DAO.AutoresDao;
import biblioteca.n1final.DAO.LivroDao;
import biblioteca.n1final.model.Autor;
import biblioteca.n1final.model.Livro;
import biblioteca.n1final.model.GeneroLivros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class LivroController implements Initializable {

    private LivroDao livroDao = new LivroDao();
    private AutoresDao autoresDao = new AutoresDao();

    @FXML
    private ListView<Livro> listaLivros;

    @FXML
    private TextField txtFieldNome;

    @FXML
    private TextField txtFieldEdicao;

    @FXML
    private TextField txtFieldNumCopias;

    @FXML
    private TextField txtFieldAno;

    @FXML
    private ComboBox<GeneroLivros> cboxGenero;

    @FXML
    private ComboBox<Autor> cboxAutor;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnExcluir;

    @FXML
    private void btnAdicionarAction (ActionEvent e){
        Livro livro = new Livro();
        livro.setNome(txtFieldNome.getText());
        livro.setEdicao(txtFieldEdicao.getText());
        livro.setAno(txtFieldAno.getText());
        livro.setGenero(cboxGenero.getValue());
        livro.setCopias(parseInt(txtFieldNumCopias.getText()));
        livro.adicionarAutor(cboxAutor.getValue());

        System.out.print(livro.toString());

        try{
            livroDao.gravar(livro);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        atualizarLista();
    }

    @FXML
    private void btnExcluirAction (ActionEvent e){

//        Livro livro = listaLivros.getSelectionModel().getSelectedItems();
//
//        try{
//            livroDao.excluir(livro);
//        }catch (Exception exp){
//            System.out.print(exp);
//        }

        listaLivros.getItems().removeAll(listaLivros.getSelectionModel().getSelectedItems());

//        try{
//            System.out.print(livroDao.listar());
//        }catch (Exception exp){
//            System.out.print(exp);
//        }
    }

    private void atualizarLista(){

        List<Livro> livros;

        try {
            livros = livroDao.listar();

        }catch (Exception e){
            livros = new ArrayList<Livro>();
        }

        ObservableList<Livro> livrosObs = FXCollections.observableArrayList(livros);
        listaLivros.setItems(livrosObs);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GeneroLivros.values();
        List<Autor> autores = new ArrayList<Autor>();
        autores = autoresDao.listar();

        ObservableList<GeneroLivros> listGenero = FXCollections.observableArrayList(GeneroLivros.values());
        cboxGenero.setItems(listGenero);

        ObservableList<Autor> listAutor = FXCollections.observableArrayList(autores);
        cboxAutor.setItems(listAutor);

        atualizarLista();
    }
}