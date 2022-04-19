package biblioteca.n1final.GUI;


import biblioteca.n1final.DAO.AlunoDao;
import biblioteca.n1final.model.Aluno;
import biblioteca.n1final.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroAlunoController implements Initializable {

    private AlunoDao alunosDao = new AlunoDao();

    @FXML
    private Button adicionarBtn;

    @FXML
    private Button excluirBtn;

    public void onActionExcluirBtn () {

        Aluno aluno = alunosList.getSelectionModel().getSelectedItem();

        try{
            alunosDao.excluir(aluno);
        }catch (Exception e){
            System.out.println(e);
        }

        atualizarLista();

    }

    @FXML
    private TextField txtFieldNome;

    @FXML
    private ListView<Aluno> alunosList;

    @FXML
    private void onActionAdd (ActionEvent e) {
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(txtFieldNome.getText());

        try{
            alunosDao.gravar(novoAluno);
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        atualizarLista();
    }

    private void atualizarLista(){

        List<Aluno> alunos = null;

        try {
            alunos = alunosDao.listar();

        }catch (Exception e){
            alunos = new ArrayList<Aluno>();
        }

        ObservableList<Aluno> alunosObs = FXCollections.observableArrayList(alunos);
        alunosList.setItems(alunosObs);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}
