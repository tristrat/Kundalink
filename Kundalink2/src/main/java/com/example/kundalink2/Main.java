package com.example.kundalink2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.YearMonth;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox calendarview = new FullCalendarView(YearMonth.now()).getView();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("todovisu.fxml"));
        Parent root2 = loader2.load();

        Scene calendar = new Scene(calendarview);
        Scene expense = new Scene(root, 700, 350);
        Scene todo = new Scene(root2, 700, 500);

        Button buttonbudget = new Button("Budget");
        buttonbudget.setOnAction(e -> primaryStage.setScene(expense));

        Button buttontodo = new Button("Todo List");
        buttontodo.setOnAction(e -> primaryStage.setScene(todo));

        HBox hbox = new HBox(buttonbudget, buttontodo);
        calendarview.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER_RIGHT);

        calendarview.setSpacing(10);

        primaryStage.setTitle("Kundalink");
        primaryStage.setScene(calendar);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
