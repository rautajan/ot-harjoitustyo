
package harjoitusohjelmageneraattori.domain;

import java.util.List;

public class User {
    private String username;
    private String password;
    private String programName;
    private WriteFile writeFile = new WriteFile();
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String setProgram(String choice){
        programName = choice;
        return writeFile.saveUser(username, password, programName);
    }
    
    
    
    //kirjoittaa käyttäjälle kuuluvan ohjelman tiedostoon
    
    
    
}
