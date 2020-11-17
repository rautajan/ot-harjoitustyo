package Harjoitusohjelmageneraattori;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Tervetuloa harjoitusohjelmageneraattoriin! Tämän sovelluksen avulla saat muutamassa sekunnissa"
                    + " valmiin ohjelman kuntosalille!");
            System.out.println("");
            System.out.println("Valitse seuraavista vaihtoehdoista harjoitustaustasi ja aikataulusi sallimien kuntosalipäivien"
                    + " lukumäärä keskimääräisen viikon aikana.");
            System.out.println("Syötä valitsemasi vaihtoehdon kirjain ja paina enter. (x+enter yhdistelmällä pääset pois sovelluksesta)");
            System.out.println("");
            System.out.println("a) Olen aloittelija (Aktiivista harjoittelua takana alle 6kk) ja minulla on aikaa käydä salilla"
                    + " vähintään kolmena päivänä viikossa");
            System.out.println("b) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                    + "salilla neljänä päivänä viikossa");
            System.out.println("b) Olen kokenut harjoittelija (Aktiivista harjoittelua takana yli 6kk) ja minulla on aikaa käydä "
                    + "salilla viitenä päivänä viikossa");
            System.out.print("Syötä parhaiten sopiva vaihtoehto: ");
            String vastaus = reader.nextLine();
            System.out.println("");

            if (vastaus.equals("x")) {
                break;

            }
            if (vastaus.equals("a")) {
                try ( Scanner fileReader = new Scanner(new File("aloittelijanOhjelma.txt"), "UTF-8")) {
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Tiedoston luku ei onnistunut.");
                }
                System.out.println("");
                System.out.println("");
                continue;
            }
            if (vastaus.equals("b")) {
                try ( Scanner fileReader = new Scanner(new File("kokenutKiireinen.txt"), "UTF-8")) {
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Tiedoston luku ei onnistunut.");
                }
                System.out.println("");
                System.out.println("");
                continue;

            }
            if (vastaus.equals("c")) {
                try ( Scanner fileReader = new Scanner(new File("kokenutEiKiireinen.txt"), "UTF-8")) {
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Tiedoston luku ei onnistunut.");
                }
                System.out.println("");
                System.out.println("");
                continue;

            } else {
                System.out.println("Virheellinen syöte, yritä uudelleen");
                System.out.println("");
                System.out.println("");
            }

        }
        System.out.println(Xtulostaja());
//        System.out.println("Kiitos ja hyviä treenihetkiä!");

    }
    
    public static String Xtulostaja() {
        String tulostus = "Kiitos ja hyviä treenihetkiä!";
        return tulostus;
    }
}
