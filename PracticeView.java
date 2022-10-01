package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dic;
    private  String randWord;

    public PracticeView(Dictionary dic) {
        this.dic = dic;
        this.randWord = dic.getRandomWords();
    }

    public Parent getView(){
        GridPane layout =new GridPane();

//Nodes initialization
        Label translate = new Label("translate the word "+"'"+randWord+"'");
        TextField englishWordField = new TextField();
        Button check = new Button("Check");
        Label correct = new Label();

//Addition of Nodes
        layout.add(translate,0,0);
        layout.add(englishWordField,0,1);
        layout.add(check,0,2);
        layout.add(correct,0,3);
//layout editing
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
//in case button check is pressed , check the correctness of the words
        check.setOnAction((event)->{
            if(dic.correct(randWord,englishWordField.getText())){
                correct.setText("correct!");

            }else{
                correct.setText("Incorrect! The translation fo the word '" + randWord + "' is '" + dic.get(randWord) + "'.");
                return;
            }
            this.randWord =dic.getRandomWords();
            translate.setText("Translate the word '" + this.randWord + "'");
            englishWordField.clear();

        });


        return layout;
    }
}
