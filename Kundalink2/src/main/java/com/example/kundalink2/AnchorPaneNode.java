package com.example.kundalink2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import com.example.kundalink2.TodolistController;
import javafx.stage.Stage;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;

    /**
     * Create an anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children){
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseClicked(event -> {
            try {
                handleMouseClick();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void handleMouseClick() throws IOException {
        Stage primaryStage = (Stage) this.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("todovisu.fxml"));
        Parent root = loader.load();
        Scene todo = new Scene(root, 700, 500);
        primaryStage.setScene(todo);
        TodolistController controller = loader.getController();
        controller.onClickDate(this.date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
