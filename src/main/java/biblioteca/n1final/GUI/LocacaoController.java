package biblioteca.n1final.GUI;

import biblioteca.n1final.DAO.AlunoDao;
import biblioteca.n1final.DAO.LivroDao;
import biblioteca.n1final.DAO.LocacaoDao;
import biblioteca.n1final.DAO.ProfessoresDao;
import biblioteca.n1final.model.*;
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
    private LocacaoDao daoLocacao = new LocacaoDao();
    private boolean professorEnable;

    @FXML
    ComboBox<Professor> cboxProfessor;

    @FXML
    ComboBox<Aluno> cboxAluno;

    @FXML
    ComboBox<Livro> cboxLivro;

    @FXML
    Button adicionarBtn;

    public void onActionAdicionarBtn () {

        Locacao novaLocacao = new Locacao();

        Livro livro = cboxLivro.getValue();
        CopiaLivro copiaLocada = livro.copiaDisponivelLocacao();

        if(copiaLocada != null){

            if(professorEnable){

                Professor professor = cboxProfessor.getValue();

                if(professor.getLocacoes().size() >= 5){
                    System.out.println("maximo de locacoes simultaneas atingidas");
                    return;
                }

                copiaLocada.setLocada(true);

                novaLocacao.setCopiaLivro(copiaLocada);
                novaLocacao.setProfessor(true);
                novaLocacao.setIdLocatario(professor.getId());
                novaLocacao.setPrazo(30);

                try{
                    daoLocacao.gravar(novaLocacao);
                    professor.adicionarLocacao(novaLocacao);
                }catch (Exception e){
                    System.out.println(e);
                }

            }else{
                Aluno aluno = cboxAluno.getValue();

                if(aluno.getLocacoes().size() >= 5){
                    System.out.println("maximo de locacoes simultaneas atingidas");
                    return;
                }

                copiaLocada.setLocada(true);

                novaLocacao.setCopiaLivro(copiaLocada);
                novaLocacao.setProfessor(false);
                novaLocacao.setIdLocatario(aluno.getId());
                novaLocacao.setPrazo(5);

                try{
                    daoLocacao.gravar(novaLocacao);
                    aluno.adicionarLocacao(novaLocacao);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        }else{
            System.out.println("livro sem copias para locacao");
            return;
        }


        atualizar();
    }

    @FXML
    Button excluirBtn;

    public void onActionExcluirBtn () {

        Locacao locacaoRemovida = locacoesListView.getSelectionModel().getSelectedItem();
        Livro livro = cboxLivro.getSelectionModel().getSelectedItem();
        CopiaLivro copiaLivro = locacaoRemovida.getCopiaLivro();

        if(locacaoRemovida.isProfessor()){

            Professor professor = daoProdessores.getProfessor(locacaoRemovida.getIdLocatario());

            if(professor != null) {

                try{
                   professor.removerLocacao(locacaoRemovida);
                   copiaLivro.setLocada(false);
                   daoLocacao.excluir(locacaoRemovida);

                }catch (Exception e){
                    System.out.println(e);
                }
            }
            
        } else {

            Aluno aluno = daoAlunos.getAluno(locacaoRemovida.getIdLocatario());

            if(aluno != null){

                try{
                    aluno.removerLocacao(locacaoRemovida);
                    copiaLivro.setLocada(false);
                    daoLocacao.excluir(locacaoRemovida);
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        }

        atualizar();
    }

    @FXML
    ListView<Locacao> locacoesListView;


    @FXML
    Toggle toggleProfessor;

    public void onActionToggelProfessor(){

        professorEnable = toggleProfessor.isSelected();

        cboxAluno.setDisable(professorEnable);
        cboxProfessor.setDisable(!professorEnable);
    }

    public void atualizar(){

        List<Locacao> locacoes;

        try{
            locacoes = daoLocacao.listar();
        }catch (Exception e){
            locacoes = new ArrayList<Locacao>();
        }

        ObservableList<Locacao> locacaosObs = FXCollections.observableArrayList(locacoes);
        locacoesListView.setItems(locacaosObs);
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
