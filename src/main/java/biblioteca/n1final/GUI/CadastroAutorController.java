package biblioteca.n1final.GUI;

import biblioteca.n1final.DAO.AutoresDao;
import biblioteca.n1final.model.Autor;
import biblioteca.n1final.model.Livro;
import biblioteca.n1final.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroAutorController implements Initializable {

    AutoresDao daoAutores = new AutoresDao();

    @FXML
    TextField nomeTxtField;

    @FXML
    TextField sobrenomeTxtField;

    @FXML
    Button adicionarBtn;

    public void adicionarBtnOnAction () {
        Autor novoAutor = new Autor();

        novoAutor.setNome(nomeTxtField.getText());
        novoAutor.setSobrenome(sobrenomeTxtField.getText());

        try{
            daoAutores.gravar(novoAutor);
        }catch (Exception e){
            System.out.print(e);
        }

        atualizarLista();
    }

    @FXML
    Button deleteBtn;

    public void deleteBtnOnAction() {

        Autor autor = autoresListView.getSelectionModel().getSelectedItem();

        try{
            daoAutores.excluir(autor);
        }catch (Exception e){
            System.out.println(e);
        }

        atualizarLista();
    }

    @FXML
    ListView<Autor> autoresListView;

    public void atualizarLista(){
        List<Autor> autores = null;

        try {
            autores = daoAutores.listar();

        }catch (Exception e){
            autores = new ArrayList<Autor>();
        }

        ObservableList<Autor> autoresObs = FXCollections.observableArrayList(autores);
        autoresListView.setItems(autoresObs);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
