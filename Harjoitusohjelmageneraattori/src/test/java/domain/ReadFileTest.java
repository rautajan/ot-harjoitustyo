
package domain;

import harjoitusohjelmageneraattori.domain.ReadFile;
import harjoitusohjelmageneraattori.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReadFileTest {
    private ReadFile readFile;
    private User user;
    
    public ReadFileTest() {
        this.readFile = new ReadFile();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void checkIfReadUsersFileReturnsCorrectStringIfNameLengthUnder4 () {
        assertEquals("Käyttäjätunnuksen tulee olla vähintään 4 merkkiä pitkä", readFile.readUsersFile("a", "password"));
    }
    
    @Test
    public void checkIfReadUserFileReturnsCorrectIfStringPasswordUnder5 () {
        assertEquals("Salasanan tulee olla vähintään 5 merkkiä pitkä", readFile.readUsersFile("testing", "q"));
    }
    
    @Test
    public void checkIfWrongPasswordOrUsername () {
        assertEquals("Käyttäjätunnus tai salasana on väärin", readFile.logIn("a", "a"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // @Test
    // public void hello() {}
}
