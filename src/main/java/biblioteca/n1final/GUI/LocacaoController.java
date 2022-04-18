package biblioteca.n1final.GUI;

import biblioteca.n1final.DAO.AlunoDao;
import biblioteca.n1final.DAO.LivroDao;
import biblioteca.n1final.DAO.ProfessoresDao;
import biblioteca.n1final.model.Aluno;
import biblioteca.n1final.model.Autor;
import biblioteca.n1final.model.Livro;
import biblioteca.n1final.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LocacaoController implements Initializable {

    private AlunoDao daoAlunos = new AlunoDao();
    private ProfessoresDao daoProdessores = new ProfessoresDao();
    private LivroDao daoLivros = new LivroDao();
    private boolean enable;

    @FXML
    ComboBox cboxProfessor;

    @FXML
    ComboBox cboxAluno;

    @FXML
    ComboBox cboxLivro;

    @FXML
    Button adicionarBtn;

    public void onActionAdicionarBtn () {

    }

    @FXML
    Button excluirBtn;

    public void onActionExcluirBtn () {

    }

    @FXML
    ListView locacaoAlunoListView;

    @FXML
    ListView locacaoProdessorListView;

    @FXML
    Toggle toggleProfessor;

    public void onActionToggelProfessor(){

        enable = toggleProfessor.isSelected();

        cboxAluno.setDisable(enable);
        cboxProfessor.setDisable(!enable);
    }

    public void atualizar(){
//        List<Aluno> alunos;
//        List<Professor> professores;
//        try{
//            alunos = daoAlunos.listar();
//            professores = daoProdessores.listar();
//        }catch (Exception e){
//            alunos = new ArrayList<Aluno>();
//            professores = new ArrayList<Professor>();
//        }
//
//        ObservableList<Aluno> listAlunos = FXCollections.observableArrayList(alunos);
//        cboxAluno.setItems(listAlunos);
//
//        ObservableList<Professor> listProfessores = FXCollections.observableArrayList(professores);
//        cboxProfessor.setItems(listProfessores);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Aluno> alunos;
        List<Professor> professores;
        List<Livro> livros;

        try{
            alunos = daoAlunos.listar();
            professores = daoProdessores.listar();
            livros = daoLivros.listar();
        }catch (Exception e){
            alunos = new ArrayList<Aluno>();
            professores = new ArrayList<Professor>();
            livros = new ArrayList<Livro>();
        }

        ObservableList<Aluno> listAlunos = FXCollections.observableArrayList(alunos);
        cboxAluno.setItems(listAlunos);

        ObservableList<Professor> listProfessores = FXCollections.observableArrayList(professores);
        cboxProfessor.setItems(listProfessores);

        ObservableList<Livro> listLivros = FXCollections.observableArrayList(livros);
        cboxLivro.setItems(listLivros);

        cboxProfessor.setDisable(true);
    }
}
