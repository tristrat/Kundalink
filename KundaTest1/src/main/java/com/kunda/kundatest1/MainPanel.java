package com.kunda.kundatest1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.Console;
import java.util.ArrayList;


//import java.util.List;

public class MainPanel {

    public ListView<List> list;
    public Label Titre;
    public Button nouveauBouton;
    @FXML
    public TextField titre;
    @FXML
    public TextArea contenu;
    public Button modifierBouton;
    public Button suprimerBouton;
    public Pane test;

    public ArrayList<List> allList = new ArrayList<>();

    public void initialize(){
        display();
    }

    public void addlist(){
        contenu.setText(titre.getText());
        List l = new List(titre.getText(),contenu.getText());
        allList.add(l);

        display();
    }

    public void display(){
        if (allList!= null) {
            ObservableList<List> total;
            total = FXCollections.observableArrayList(allList);
            list.setItems(total);
            
        }


    }

}
