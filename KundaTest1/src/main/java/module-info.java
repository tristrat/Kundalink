module com.kunda.kundatest1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.kunda.kundatest1 to javafx.fxml;
    exports com.kunda.kundatest1;
}