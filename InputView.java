package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dic;

    public InputView(Dictionary dic) {
        this.dic = dic;
    }

    public Parent getView(){
        GridPane layout =new GridPane();
//Nodes initialization
        Label word = new Label("Word");
        TextField foriegnWordField = new TextField();
        Label translation = new Label("Translation");
        TextField englishWordField = new TextField();
        Button add = new Button("Add the word pair");
//Addition of Nodes
        layout.add(word,0,0);
        layout.add(foriegnWordField,0,1);
        layout.add(translation,0,2);
        layout.add(englishWordField,0,3);
        layout.add(add,0,4);
//layout editing
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
//if add button is pressed , add words to the dictionary obj.
        add.setOnAction((event)->{
            dic.add(foriegnWordField.getText(),englishWordField.getText());
            foriegnWordField.clear();
            englishWordField.clear();
        });
        return layout;
    }
}
