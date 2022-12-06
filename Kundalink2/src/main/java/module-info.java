module com.example.kundalink2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kundalink2 to javafx.fxml;
    exports com.example.kundalink2;
}