package harjoitusohjelmageneraattori.ui;

import harjoitusohjelmageneraattori.domain.Logic;
import java.util.Scanner;

public class Ui {

    private Scanner reader;
    private Logic logic;

    public Ui(Scanner reader, Logic logic) {
        this.reader = reader;
        this.logic = logic;
    }

    public void start() {
        System.out.println(askUserInfo());
    }

    public String askUserInfo() {
        while (true) {
            System.out.println("Tervetuloa harjoitusohjelmageneraattoriin! Tämän sovelluksen avulla saat muutamassa sekunnissa"
                    + " valmiin ohjelman kuntosalille!");
            System.out.println("Valitse ensimmäiseksi seuraavista vaihtoehdoista harjoitustaustasi ja aikataulusi sallimien kuntosalipäivien"
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
            String answer = reader.nextLine();
            if (answer.equals("x")) {
                break;
            }
            System.out.println("");
            System.out.println("Valitse vielä seuraavista vaihtoehdoista itseäsi parhaiten kuvaavat, niin saadaan luotua paremmin tarpeisiisi sopiva ohjelma");
            System.out.println("Olen nainen - syötä n + Enter, Olen mies - syötä m + Enter");
            answer += reader.nextLine();
            if (answer.equals("x")) {
                break;
            }
            System.out.println("Olen 18-49 vuotias: syötä n + Enter, Olen 50-65 vuotias: syötä v + Enter");
            answer += reader.nextLine();
            if (answer.equals("x")) {
                break;
            } else {
                System.out.println("");
                System.out.println(logic.readFile(answer));
            }
        }
        return "Kiitos ja hyviä treenihetkiä!";
    }
}
