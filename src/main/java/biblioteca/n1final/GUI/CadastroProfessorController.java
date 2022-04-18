package biblioteca.n1final.GUI;

import biblioteca.n1final.DAO.ProfessoresDao;
import biblioteca.n1final.model.Aluno;
import biblioteca.n1final.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroProfessorController implements Initializable {

    ProfessoresDao professoresDao = new ProfessoresDao();

    @FXML
    TextField nomeTxtField;

    @FXML
    Button adicionarBtn;

    @FXML
    ListView professoresListView;

    @FXML
    public void adicionarBtnOnAction(){
        Professor novoProfessor = new Professor();
        novoProfessor.setNome(nomeTxtField.getText());
        try{
            professoresDao.gravar(novoProfessor);
        }catch (Exception e){
            System.out.print(e);
        }

        atualizarLista();
    }

    private void atualizarLista () {
        List<Professor> professores = null;

        try {
            professores = professoresDao.listar();

        }catch (Exception e){
            professores = new ArrayList<Professor>();
        }

        ObservableList<Professor> professoresObs = FXCollections.observableArrayList(professores);
        professoresListView.setItems(professoresObs);
    }

    @FXML
    Button excluirBtn;

    @FXML
    public void excluirBtnOnAction () {
        System.out.print("here");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}
