module com.example.exerciciomvcclube {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exerciciomvcclube to javafx.fxml;
    exports com.example.exerciciomvcclube;
}