package harjoitusohjelmageneraattori.ui;

import javafx.application.Application;
import harjoitusohjelmageneraattori.domain.User;
import harjoitusohjelmageneraattori.domain.ReadFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ui extends Application {

    private ReadFile readFile;
    private User user;

    public Ui() {
        this.readFile = new ReadFile();
    }

    public static void main(String[] args) {
        launch(Ui.class);
    }

    @Override
    public void start(Stage startingStage) throws Exception {
        welcome(startingStage);
    }

    public void welcome(Stage mainStage) throws Exception {
//        BorderPane setting = new BorderPane();
        Label textcomponent = new Label("Tervetuloa harjoitusohjelmageneraattoriin! \n Tämän sovelluksen avulla voit luoda juuri "
                + "sinun tarpeisiisi sopivan harjoitusohjelman.");
        //textcomponent.setFont(Font.font(answer, FontWeight.THIN, 0));
        Button logInButton = new Button("Näytä ohjelmani");
        Button createUserButton = new Button("Olen uusi käyttäjä");

        Button exitButton = new Button("Sulje");
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(textcomponent, logInButton, createUserButton, exitButton);

        exitButton.setOnAction((e) -> {
            mainStage.close();
        });
        logInButton.setOnAction((e) -> {
            logIn(mainStage);
        });
        createUserButton.setOnAction((e) -> {

            try {
                createUser(mainStage);
            } catch (Exception ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        Scene welcomeView = new Scene(layout, 800, 600);
        mainStage.setTitle("Tervetuloa");
        mainStage.setScene(welcomeView);
        mainStage.show();
    }

    public void logIn(Stage mainStage) {
        Label errorMessage = new Label("");
        Label userName = new Label("Anna käyttäjätunnus");
        Label password = new Label("Anna salasana");
        Label infoText = new Label();
        Button logInButton = new Button("Kirjaudu sisään");
        Button backButton = new Button("Takaisin");

        TextField userText = new TextField();
        TextField passwordText = new TextField();
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(errorMessage, userName, userText, password, passwordText, logInButton, backButton);

        logInButton.setOnAction((e) -> {
            String message = readFile.logIn(userText.getText(), passwordText.getText());
            if (message.length() > 100) {

                showProgram(mainStage, message);
            }
            errorMessage.setText(message);
        });

        backButton.setOnAction((e) -> {
            try {
                welcome(mainStage);
            } catch (Exception ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene logInView = new Scene(layout, 800, 600);
        mainStage.setTitle("Kirjaudu sisään");
        mainStage.setScene(logInView);
        mainStage.show();

    }

    public void userInfo(Stage mainStage) {
        Label infoText = new Label("Vastaa alla oleviin kysymyksiin,"
                + " niin osaan luoda sopivan ohjelman sinulle.");
        VBox rootAlignment = new VBox(30);
        GridPane questions = new GridPane();
        rootAlignment.setAlignment(Pos.TOP_CENTER);
        questions.setPadding(new Insets(20));
        questions.setAlignment(Pos.CENTER);
        Label questionInfo1 = new Label("Harjoitushistoria");
        Label questionInfo2 = new Label("Sukupuoli");
        Label questionInfo3 = new Label("Ikä");
        RadioButton question1a = new RadioButton("Olen aloittelija (Aktiivista harjoittelua takana alle 6kk) ja minulla on aikaa käydä salilla"
                + " vähintään kolmena päivänä viikossa");
        RadioButton question1b = new RadioButton("Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                + "salilla neljänä päivänä viikossa");
        RadioButton question1c = new RadioButton("Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                + "salilla viitenä päivänä viikossa");
        RadioButton question2a = new RadioButton("Olen mies");
        RadioButton question2b = new RadioButton("Olen nainen");
        RadioButton question3a = new RadioButton("Olen 18-49 vuotias");
        RadioButton question3b = new RadioButton("Olen 50-65 vuotias");

        ToggleGroup setAnswer1 = new ToggleGroup();
        question1a.setToggleGroup(setAnswer1);
        question1b.setToggleGroup(setAnswer1);
        question1c.setToggleGroup(setAnswer1);

        ToggleGroup setAnswer2 = new ToggleGroup();
        question2a.setToggleGroup(setAnswer2);
        question2b.setToggleGroup(setAnswer2);

        ToggleGroup setAnswer3 = new ToggleGroup();
        question3a.setToggleGroup(setAnswer3);
        question3b.setToggleGroup(setAnswer3);

        questions.add(question1a, 0, 1);
        questions.add(question1b, 0, 2);
        questions.add(question1c, 0, 3);
        questions.add(question2a, 0, 5);
        questions.add(question2b, 0, 6);
        questions.add(question3a, 0, 8);
        questions.add(question3b, 0, 9);
        questions.add(questionInfo1, 0, 0);
        questions.add(questionInfo2, 0, 4);
        questions.add(questionInfo3, 0, 7);

        Label answerInfo = new Label("Syötä vastauksesi alla olevaan tekstikenttään. Tyyliin: aaa (Aloitteleva 18-49 vuotias mies)");
        TextField answer = new TextField();
        Button answerButton = new Button("Näytä harjoitusohjelmani");
        rootAlignment.getChildren().addAll(infoText, questions, answerButton);

        answerButton.setOnMouseClicked((e) -> {
            String choice = "";
            RadioButton answer1 = (RadioButton) setAnswer1.getSelectedToggle();
            if (answer1.getText().equals("Olen aloittelija (Aktiivista harjoittelua takana alle 6kk) ja minulla on aikaa käydä salilla"
                    + " vähintään kolmena päivänä viikossa")) {
                choice += "a";
            }
            if (answer1.getText().equals("Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                    + "salilla neljänä päivänä viikossa")) {
                choice += "b";
            }
            if (answer1.getText().equals("Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                    + "salilla viitenä päivänä viikossa")) {
                choice += "c";
            }
            RadioButton answer2 = (RadioButton) setAnswer2.getSelectedToggle();
            if (answer2.getText().equals("Olen mies")) {
                choice += "a";
            }
            if (answer2.getText().equals("Olen nainen")) {
                choice += "b";
            }
            RadioButton answer3 = (RadioButton) setAnswer3.getSelectedToggle();
            if (answer3.getText().equals("Olen 18-49 vuotias")) {
                choice += "a";
            }
            if (answer3.getText().equals("Olen 50-65 vuotias")) {
                choice += "b";
            }

            String program = readFile.readProgramFile(choice);

            if (!(program.equals("Tiedoston luku ei onnistunut."))) {
                String userSaved = user.setProgram(choice);
                showProgram(mainStage, program);
            }
        }
        );

        Scene userInfoScene = new Scene(rootAlignment, 800, 600);
        mainStage.setScene(userInfoScene);
        mainStage.setTitle("Kysely");

    }

    public void showProgram(Stage mainStage, String answer) {
        Label program = new Label(answer);
        program.setAlignment(Pos.TOP_CENTER);

        Scene showProgramScene = new Scene(program, 1000, 1100);
        mainStage.setScene(showProgramScene);
        mainStage.setTitle("Harjoitusohjelma");

    }

    public void createUser(Stage mainStage) throws Exception {
        Label errorInfo = new Label("");
        Label usernameInfo = new Label("Anna käyttäjätunnus, joka on vähintään 4 merkkiä pitkä");
        TextField username = new TextField();
        Label passwordInfo = new Label("Anna salasana, joka on vähintään 5 merkkiä pitkä");
        TextField password = new TextField();
        Button createButton = new Button("Luo tunnukset");
        Button backButton = new Button("Takaisin");
        VBox layoutCreateUser = new VBox(20);
        layoutCreateUser.getChildren().addAll(errorInfo, usernameInfo, username, passwordInfo, password, createButton, backButton);
        createButton.setOnAction((e) -> {
            String message = readFile.readUsersFile(username.getText(), password.getText());
            if (message.equals("ok")) {
                this.user = new User(username.getText(), password.getText());
                userInfo(mainStage);

            } else {
                errorInfo.setText(message);
            }
        });
        backButton.setOnAction((e) -> {
            try {
                welcome(mainStage);
            } catch (Exception ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene createUserScene = new Scene(layoutCreateUser, 600, 600);
        mainStage.setScene(createUserScene);
        mainStage.setTitle("Luo tunnukset");

    }

    @Override
    public void stop() {

    }

}
