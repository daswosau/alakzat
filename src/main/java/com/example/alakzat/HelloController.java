package com.example.alakzat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selector();

        listView.setOnMouseClicked(event -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                System.out.println("Selected: " + selected);
                setOutputImage(selected);
            }
        });

    }


    @FXML
    ObservableList<String> names = FXCollections.observableArrayList();

    @FXML
    ListView<String> listView = new ListView<>();

    @FXML
    Image square = new Image(Objects.requireNonNull(getClass().getResource("/com/example/alakzat/icons/negyzet.png")).toExternalForm());
    Image circle = new Image(Objects.requireNonNull(getClass().getResource("/com/example/alakzat/icons/kor.png")).toExternalForm());
    Image triangle = new Image(Objects.requireNonNull(getClass().getResource("/com/example/alakzat/icons/haromszog.png")).toExternalForm());

    @FXML
    private ToggleGroup colour, shape;

    @FXML
    private ImageView shapeImg;

    @FXML
    private Label imageWall;

    public String selectShape = "";
    public String selectColour = "";

    public void setOutputImage(String input) {
        String[] processed = input.split(", ");
        System.out.println(processed[0]);
        if(processed[0].equals("Négyzet")) {
            shapeImg.setImage(square);
        }
        if(processed[0].equals("Kör")) {
            shapeImg.setImage(circle);
        }
        if(processed[0].equals("Háromszög")) {
            shapeImg.setImage(triangle);
        }

        if(processed[1].equals("Piros")) {
            imageWall.setStyle("-fx-background-color: #ff0000; -fx-border-color: black;");
        }
        if(processed[1].equals("Kék")) {
            imageWall.setStyle("-fx-background-color: #0000ff; -fx-border-color: black;");
        }
        if(processed[1].equals("Zöld")) {
            imageWall.setStyle("-fx-background-color: #00ff00; -fx-border-color: black;");
        }
    }

    public void selector() {
        System.out.println("Selector ran");

        RadioButton selColour = (RadioButton)colour.getSelectedToggle();
        selectColour = selColour.getText();

        RadioButton selShape = (RadioButton)shape.getSelectedToggle();
        selectShape = selShape.getText();

        System.out.println(selectShape + ", " + selectColour);
        setOutputImage(selectShape + ", " + selectColour);
    }

    public void addItem() {

        names.add(selectShape + ", " + selectColour);


        listView.setItems(names);
        System.out.println("Items in listview: " + listView.getItems());
        System.out.println("addItem ran: " + names);
        System.out.println(listView.getSelectionModel().getSelectedIndex());
    }

    public void delItem() {

        names.remove(names.get(listView.getSelectionModel().getSelectedIndex()));
    }

    public void saveList() {
        try (FileWriter myWriter = new FileWriter("alakzatok.txt", true)) {
            for(String s : names) {
                myWriter.write(s + "\n");
                System.out.println("Written: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
