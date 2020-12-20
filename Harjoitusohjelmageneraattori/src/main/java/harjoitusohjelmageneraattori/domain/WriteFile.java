package harjoitusohjelmageneraattori.domain;

import java.io.File;
import java.io.FileWriter;

public class WriteFile {

    private User user;

    public WriteFile() {

    }

    public String saveUser(String username, String password, String programname){
        try ( FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(username + ";" + password + ";" + programname + "\n");

        } catch (Exception e) {
            return "Tallentaminen ei onnistunut";
        }
        return "Tallennus onnistui";
    } 
}
