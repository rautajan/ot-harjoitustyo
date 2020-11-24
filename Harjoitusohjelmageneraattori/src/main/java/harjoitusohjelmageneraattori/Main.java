
package harjoitusohjelmageneraattori;

import harjoitusohjelmageneraattori.domain.Logic;
import harjoitusohjelmageneraattori.ui.Ui;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Logic logic = new Logic();
        Ui ui = new Ui(reader, logic);
        ui.start();
    
    
        
    }
}
