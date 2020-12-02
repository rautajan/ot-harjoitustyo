package harjoitusohjelmageneraattori.ui;

import javafx.application.Application;
import harjoitusohjelmageneraattori.domain.Logic;
import java.io.IOException;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.text.html.CSS;

public class Ui extends Application {

    private Logic logic; // 
    private String answer;
    


    public static void main(String[] args) {
        launch(Ui.class);
    }
    @Override
    public void start(Stage startingStage) {
        welcome(startingStage);
    }

    
    public void welcome(Stage mainStage){
//        BorderPane setting = new BorderPane();
        Label textcomponent = new Label("Tervetuloa harjoitusohjelmageneraattoriin! \n Tämän sovelluksen avulla voit luoda juuri "
                + "sinun tarpeisiisi sopivan harjoitusohjelman.");
        //textcomponent.setFont(Font.font(answer, FontWeight.THIN, 0));
        Button startButton = new Button("Aloita");
        Button exitButton = new Button("Lopeta");
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(textcomponent, startButton, exitButton);
        
        exitButton.setOnAction((e) -> {
            mainStage.close();
        });
        startButton.setOnAction((e) -> {
            userInfo(mainStage);
        });
        
        
        Scene welcomeView = new Scene(layout, 800, 600);
        mainStage.setTitle("Tervetuloa");
        mainStage.setScene(welcomeView);
        mainStage.show();
    }
        
    public void userInfo(Stage mainStage) {
        Label infoText = new Label("Vastaa alla oleviin kysymyksiin,"
                + " niin osaan luoda sopivan ohjelman sinulle.");
        VBox rootAlignment = new VBox(20);
        GridPane questions = new GridPane();
        rootAlignment.setAlignment(Pos.TOP_CENTER);
        questions.setPadding(new Insets(20));
        questions.setAlignment(Pos.CENTER);
        Label question1 = new Label("a) Olen aloittelija (Aktiivista harjoittelua takana alle 6kk) ja minulla on aikaa käydä salilla"
                    + " vähintään kolmena päivänä viikossa \n"
                + "b) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä " 
                +     "salilla neljänä päivänä viikossa \n"
                + "c) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä " +
                    "salilla viitenä päivänä viikossa");
        Label question2 = new Label("a) Olen mies \nb) Olen Nainen");
        Label question3 = new Label("a) Olen 18-49 vuotias \nb) Olen 50-65 vuotias");
        Label questionInfo1 = new Label("Kysymys 1");
        Label questionInfo2 = new Label("Kysymys 2");
        Label questionInfo3 = new Label("Kysymys 3");
        questions.add(question1, 0, 1);
        questions.add(question2, 0, 3);
        questions.add(question3, 0, 5);
        questions.add(questionInfo1, 0, 0);
        questions.add(questionInfo2, 0, 2);
        questions.add(questionInfo3, 0, 4);
        
        Label answerInfo = new Label("Syötä vastauksesi alla olevaan tekstikenttään. Tyyliin: aaa (Aloitteleva 18-49 vuotias mies)");
        TextField answer = new TextField();
        Button answerButton = new Button("Näytä harjoitusohjelmani");
        questions.add(answerInfo, 0, 6);
        questions.add(answer, 0, 7);
        rootAlignment.getChildren().addAll(infoText, questions, answerButton);
        
        answerButton.setOnMouseClicked((e) -> {
            String programcode = answer.getText();
            showProgram(mainStage, programcode);
            
        });
        
        Scene userInfoScene = new Scene(rootAlignment, 800, 600);
        mainStage.setScene(userInfoScene);
        mainStage.setTitle("Kysely");
    }
    
    public void showProgram(Stage mainStage, String answer) {
        String fetchedProgram = logic.readFile(answer);
        Label program = new Label(fetchedProgram);
        program.setAlignment(Pos.TOP_CENTER);
        
        
        
        
        Scene showProgramScene = new Scene(program, 800, 600);
        mainStage.setScene(showProgramScene);
        mainStage.setTitle("Harjoitusohjelma");
        
    }
    
    

    
    
    @Override
    public void stop() {
        
    }
    

}
