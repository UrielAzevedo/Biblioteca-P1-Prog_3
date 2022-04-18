module biblioteca.n1final {
    requires javafx.controls;
    requires javafx.fxml;

    opens biblioteca.n1final to javafx.fxml;
    exports biblioteca.n1final;
    exports biblioteca.n1final.GUI;
    opens biblioteca.n1final.GUI to javafx.fxml;
}