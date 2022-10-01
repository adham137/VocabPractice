package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //initialization of both views
        PracticeView practiceView = new PracticeView(this.dictionary);
        InputView inputView = new InputView(this.dictionary);


        BorderPane layout = new BorderPane();


        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);


        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

//adding the nodes
        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);


//if enter button is pressed the input view is set as the main layout
        enterButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
//if practice button is pressed the practice view is set as the main layout
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));

//input view is set as the main layout at the start of the program
        layout.setCenter(inputView.getView());


        Scene view = new Scene(layout, 400, 300);


        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
       launch(VocabularyPracticeApplication.class);

    }
}