package harjoitusohjelmageneraattori.domain;

import harjoitusohjelmageneraattori.ui.Ui;
import java.io.File;
import java.util.Scanner;

public class ReadFile {
    private Ui Ui;
    private User user;

    public String readUsersFile(String name, String password) {
        if(name.length()<4) {
            return "Käyttäjätunnuksen tulee olla vähintään 4 merkkiä pitkä";
        }
        if(password.length()<5) {
            return "Salasanan tulee olla vähintään 5 merkkiä pitkä";
        }

        try ( Scanner fileReader = new Scanner(new File("users.txt"), "UTF-8")) {
            while (fileReader.hasNextLine()) {
                String[] parts = fileReader.nextLine().split(";");
                if (parts[0].equals(name)) {
                    return "Käyttäjätunnus on jo käytössä";
                }
            }
        } catch (Exception e) {
            return "Tiedoston luku ei onnistunut.";
        }
        return "ok";

    }
    
    public String logIn(String name, String password) {
        try ( Scanner fileReader = new Scanner(new File("users.txt"), "UTF-8")) {
            while (fileReader.hasNextLine()) {
                String[] parts = fileReader.nextLine().split(";");
                if (parts[0].equals(name) && parts[1].equals(password)) {
                    return "Onnistui";
                }
                else {
                    return "Käyttäjätunnus tai salasana on väärin";
                }
            }
        } catch (Exception e) {
            return "Tiedoston luku ei onnistunut.";
        }
        return "Jokin meni vikaan";
    }
    
    
    
     public String readProgramFile(String file) {
        System.out.println("Päästiin perille");
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
