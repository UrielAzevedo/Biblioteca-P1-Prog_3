package biblioteca.n1final;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    Button AlunoBtn;

     public void onActionAlunoBtn () {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro-aluno-view.fxml"));
             Parent rootOne = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("alunoCRUD");
             stage.setScene(new Scene(rootOne));
             stage.show();
         } catch (Exception e){
             System.out.print(e);
         }
     }

    @FXML
    Button ProfessorBtn;

     public void onActionProfessorBtn () {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro-professor-view.fxml"));
             Parent rootTwo = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("professorCRUD");
             stage.setScene(new Scene(rootTwo));
             stage.show();
         } catch (Exception e){
             System.out.print(e);
         }
     }

    @FXML
    Button AutorBtn;

     public void onActionAutorBtn () {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro-autor-view.fxml"));
             Parent rootThree = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("autorCRUD");
             stage.setScene(new Scene(rootThree));
             stage.show();
         } catch (Exception e){
             System.out.print(e);
         }
     }

    @FXML
    Button LivroBtn;

     public void onActionLivroBtn () {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("livro-view.fxml"));
             Parent rootFour = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setTitle("livroCRUD");
             stage.setScene(new Scene(rootFour));
             stage.show();
         } catch (Exception e){
             System.out.print(e);
         }
     }

    @FXML
    Button gerenciarLocacaoBtn;

    public void onActionGerenciarLocacao () {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gerenciar-locacao-view.fxml"));
            Parent rootFive = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("locacaoCRUD");
            stage.setScene(new Scene(rootFive));
            stage.show();
        }catch (Exception e){
            System.out.print(e);
        }
    }

}
