package harjoitusohjelmageneraattori.domain;

import harjoitusohjelmageneraattori.ui.Ui;
import java.io.File;
import java.util.Scanner;

public class Logic {

    public Logic() {

    }

    public String readFile(String file) {
        String program = "";
        String programFile = file;
        if (file.equals("aab")) {
            programFile = "miesAloittelijaVanha.txt";
        }
        if (file.equals("aaa")) {
            programFile = "miesAloittelijanOhjelmaNuori.txt";
        }
        if (file.equals("caa")) {
            programFile = "miesNuoriKokenutEiKiireinen.txt";
        }
        if (file.equals("baa")) {
            programFile = "miesNuoriKokenutKiireinen.txt";
        }
        if (file.equals("bab")) {
            programFile = "miesVanhaKokenutKiireinen.txt";
        }
        if (file.equals("aba")) {
            programFile = "nainenAloittelijaNuori.txt";
        }
        if (file.equals("abb")) {
            programFile = "nainenAloittelijaVanha.txt";
        }
        if (file.equals("cba")) {
            programFile = "nainenNuoriKokenutEiKiireinen.txt";
        }
        if (file.equals("bba")) {
            programFile = "nainenNuoriKokenutKiireinen.txt";
        }
        if (file.equals("cbb")) {
            programFile = "nainenVanhaKokenutEikiireinen.txt";
        }
        if (file.equals("bbb")) {
            programFile = "nainenVanhaKokenutKiireinen.txt";
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
