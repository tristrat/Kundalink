package com.example.kundalink2;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ResourceBundle;

public class TodolistController implements Initializable {

    @FXML
    private Button btnAddns;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnBudget;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;


    @FXML
    private DatePicker dpDate;


    @FXML
    private Label lblComments;


    @FXML
    private Label lblLos;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSd;

    @FXML
    private Label lbldate;

    @FXML
    private ListView<Todolist> lvLos;

    @FXML
    private TextArea txtaComments;


    @FXML
    private TextField txtfName;

    private static LocalDate date;

    DBManager manager;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager = new DBManager();
        lvLos.getSelectionModel().selectedItemProperty().addListener(e ->
                displayStudentDetails(lvLos.getSelectionModel().getSelectedItem()));

        fetchStudents();
        this.dpDate.setValue(LocalDate.of(2022,12,12));
    }

    private void displayStudentDetails(Todolist selectedTodolist) {
        if (selectedTodolist != null) {
            txtfName.setText(selectedTodolist.getName());

            dpDate.setValue(selectedTodolist.getBirth_date());

            txtaComments.setText(selectedTodolist.getComments());

        }
    }

    public void onCalendarClicked(ActionEvent e) throws IOException {
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        VBox calendarview = new FullCalendarView(YearMonth.now()).getView();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("todovisu.fxml"));
        Parent root2 = loader2.load();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Scene calendar = new Scene(calendarview);
        Scene todo = new Scene(root2, 700, 500);
        Scene expense = new Scene(root, 700, 350);

        Button buttonbudget = new Button("Budget");
        buttonbudget.setOnAction(event -> primaryStage.setScene(expense));
        Button buttontodo = new Button("Todo List");
        buttontodo.setOnAction(event -> primaryStage.setScene(todo));

        HBox hbox = new HBox(buttonbudget, buttontodo);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        calendarview.getChildren().add(hbox);
        calendarview.setSpacing(10);

        primaryStage.setScene(calendar);
    }

    public void onBudgetClicked (ActionEvent e) throws IOException {
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene expense = new Scene(root, 700, 350);

        primaryStage.setScene(expense);
    }

    public void fetchStudents() {
        List<Todolist> listStudents = manager.loadTodolist();

        if (listStudents != null) {
            ObservableList<Todolist> students;
            students = FXCollections.observableArrayList(listStudents);
            lvLos.setItems(students);
        }
    }
    public void onNew(){
        lvLos.getSelectionModel().clearSelection();
        this.txtfName.clear();
        this.dpDate.setValue(null);
        this.txtaComments.clear();
    }

    public void onClickDate(LocalDate date){
        lvLos.getSelectionModel().clearSelection();
        this.txtfName.clear();
        this.dpDate.setValue(date);
        this.txtaComments.clear();
    }


    public void onCancel(){
        lvLos.getSelectionModel().selectFirst();
    }

    public void onSave() {


            int newid = lvLos.getItems().size() + 1;
        Todolist s = new Todolist(newid, txtfName.getText(), dpDate.getValue(), txtaComments.getText());// etape 1
            manager.addTodolist(s);
            fetchStudents();
            //Average.setText(String.valueOf(manager.average()));



    }
    public void onEdit() {
        try{
            Todolist s = lvLos.getSelectionModel().getSelectedItem();
            Todolist news= new Todolist(0, txtfName.getText(),
                    dpDate.getValue(),  txtaComments.getText()); // To test if the values are corrects
            manager.editTodolist(s,this.txtfName.getText(),
                    this.dpDate.getValue(),
                    this.txtaComments.getText());
            fetchStudents();
            //Average.setText(String.valueOf(manager.average()));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in task!");
            onCancel();
            Platform.runLater(() -> {
                Alert dialog = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                dialog.show();
            });
            fetchStudents();
        }
    }
    public void onDelete() {
        Todolist s = lvLos.getSelectionModel().getSelectedItem();
        manager.deleteTodolist(s);
        fetchStudents();
        this.txtfName.clear();

        this.dpDate.setValue(null);

        this.txtaComments.clear();

    }

}





