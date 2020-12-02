package harjoitusohjelmageneraattori.ui;

import javafx.application.Application;
import harjoitusohjelmageneraattori.domain.Logic;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.text.html.CSS;

public class Ui extends Application {

    private Scanner reader;
    private Logic logic; // 
    private String answer;
    
    public Ui() {
        this.answer = "";
    }

//    public Ui(Scanner reader, Logic logic) {
//        this.reader = reader;
//        this.logic = logic;
//    }
    public static void main(String[] args) {
        launch(Ui.class);
    }
    @Override
    public void start(Stage startingStage) {
        welcome(startingStage);
    }

    
    public void welcome(Stage startingStage) {
        String answer = "";
//        BorderPane setting = new BorderPane();
        Label textcomponent = new Label("Tervetuloa harjoitusohjelmageneraattoriin! \n Tämän sovelluksen avulla voit luoda juuri "
                + "sinun tarpeisiisi sopivan harjoitusohjelman.");
        Button startButton = new Button("Aloita");
        Button exitButton = new Button("Lopeta");
//        setting.setLeft(startButton);
//        setting.setRight(exitButton);
//        setting.setCenter(textcomponent);
        GridPane setting = new GridPane();
        setting.add(textcomponent, 0, 0);
        setting.add(startButton, 0, 1);
        setting.add(exitButton, 0, 2);

        setting.setPrefSize(500, 400);
        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        
        Label askInfo = new Label("Vastaa alla oleviin kysymyksiin, niin osaan luoda sopivan ohjelman sinulle. \n "
                + "Syötä parhaiten itseäsi kuvaavan vaihtoehdon kirjain tekstikenttään.\n");
        Label questionOne = new Label("a) Olen aloittelija (Aktiivista harjoittelua takana alle 6kk) ja minulla on aikaa käydä salilla"
                    + " vähintään kolmena päivänä viikossa \n"
                + "b) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä " 
                +     "salilla neljänä päivänä viikossa \n"
                + "c) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä " +
                    "salilla viitenä päivänä viikossa \n");
        TextField answerOne = new TextField();
        Button answerOneButton = new Button("Tallenna vastaus");
        
        Label questionTwo = new Label("a) Olen mies \nb) Olen Nainen");
        TextField answerTwo = new TextField();
        Button answerTwoButton = new Button("Tallenna vastaus");
        Label questionThree = new Label("a) Olen 18-49 vuotias \nb) Olen 50-65 vuotias");
        TextField answerThree = new TextField();
        Button answerThreeButton = new Button("Tallenna vastaus");
        
        Button showProgramButton = new Button("Näytä ohjelmani");
        
        
        
        
        GridPane askSetting = new GridPane();
        VBox rootPane = new VBox(20);
        rootPane.setAlignment(Pos.CENTER);
        
        askSetting.setPrefSize(600, 600);
        askSetting.add(askInfo, 0, 0);
        askSetting.add(questionOne, 0, 1);
        askSetting.add(answerOne, 0, 2);
        askSetting.add(answerOneButton, 0, 3);
        askSetting.add(questionTwo, 0, 4);
        askSetting.add(answerTwo, 0, 5);
        askSetting.add(answerTwoButton, 0, 6);
        askSetting.add(questionThree, 0, 7);
        askSetting.add(answerThree, 0, 8);
        askSetting.add(answerThreeButton, 0, 9);
        askSetting.add(showProgramButton, 0, 10);
        askSetting.setAlignment(Pos.TOP_CENTER);
        Scene askView = new Scene(askSetting);
        
        FlowPane programLayout = new FlowPane();
        String program = logic.readFile(this.answer);
        Label showProgram = new Label(program);
        programLayout.getChildren().add(showProgram);
        
        Scene programview = new Scene(programLayout);
        
        
      
        
        exitButton.setOnAction((event) -> {
            startingStage.close();
        });
        startButton.setOnAction((event) -> {
            startingStage.setScene(askView);
           
        });
        answerOneButton.setOnAction((event) -> {
            saveAnswers(answerOne.getText());
        });
        
        answerTwoButton.setOnAction((event) -> {
            saveAnswers(answerTwo.getText());
        });
        
        answerThreeButton.setOnAction((event) -> {
            saveAnswers(answerThree.getText());
        });
        showProgramButton.setOnAction((event) -> {
            startingStage.setScene(programview);
        });
        
        
        

        Scene view = new Scene(setting);
        //Scene askView = new Scene(askSetting);
        startingStage.setTitle("Harjoitusohjelmageneraattori");
        startingStage.setScene(view);
        startingStage.show();
    }
    
    public void saveAnswers(String answer) {
        this.answer += answer;
        System.out.println(answer);
        
    }
   
    
    
//    @Override
//    public void stop() {
//        
//    }
//    

}
