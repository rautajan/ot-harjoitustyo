
package harjoitusohjelmageneraattori.domain;

import java.util.HashMap;

public class Program {
    
    //private String newProgram;
    private HashMap<String, String> programs;
    
    
    private String getProgrman(String answer) {
        return programs.get(answer);
        
    }
}
