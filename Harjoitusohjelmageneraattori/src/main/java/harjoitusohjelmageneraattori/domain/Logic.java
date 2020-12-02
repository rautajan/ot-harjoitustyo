
package harjoitusohjelmageneraattori.domain;

import harjoitusohjelmageneraattori.ui.Ui;
import java.io.File;
import java.util.Scanner;

public class Logic {
    
    public Logic() {
        
        
    }
    
    public String readFile(String file) {
        String program = "";
        System.out.println("päästiin perille" + file);
        String programFile = file;
        if (file.equals("amv")) {
            programFile = "miesAloittelijaVanha.txt";
        }
        if (file.equals("aaa")) {
            programFile = "miesAloittelijanOhjelmaNuori.txt";
        }
        if (file.equals("cmn")) {
            programFile = "miesNuoriKokenutEiKiireinen.txt";
        }
        if (file.equals("bmn")) {
            programFile = "miesNuoriKokenutKiireinen.txt";
        }
        if (file.equals("bmv")) {
            programFile = "miesVanhaKokenutKiireinen.txt";
        }
        if (file.equals("ann")) {
            programFile = "nainenAloittelijaNuori.txt";
        }
        if (file.equals("anv")) {
            programFile = "nainenAloittelijaVanha.txt";
        }
        if (file.equals("cnn")) {
            programFile = "nainenNuoriKokenutEiKiireinen.txt";
        }
        if (file.equals("bnn")) {
            programFile = "nainenNuoriKokenutKiireinen.txt";
        }
        if (file.equals("cnv")) {
            programFile = "nainenVanhaKokenutEiKiireinen.txt";
        }
        if (file.equals("bnv")) {
            programFile = "nainenVanhaKOkenutKiireinen.txt";
        }
        
        try ( Scanner fileReader = new Scanner(new File(programFile), "UTF-8")) {
                    while (fileReader.hasNextLine()) {
                        program += (fileReader.nextLine()) + "\n";
                    }
                } catch (Exception e) {
                    program = "Tiedoston luku ei onnistunut.";
                }
        return program;
        
    }
    
}
