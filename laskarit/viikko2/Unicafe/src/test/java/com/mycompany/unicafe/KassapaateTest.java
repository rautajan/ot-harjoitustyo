package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;
    Maksukortti kortti2;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti2 = new Maksukortti(5);
    }

    @Test
    public void MaukkaatlounaatAlussa() {
        assertEquals(String.valueOf("0"), String.valueOf(paate.maukkaitaLounaitaMyyty()));

    }

    @Test
    public void EdullisetlounaatAlussa() {
        assertEquals(String.valueOf("0"), String.valueOf(paate.edullisiaLounaitaMyyty()));

    }

    @Test
    public void rahatAlussa() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void VaihtorahaOikeinEdullisella() {
        assertEquals(60, paate.syoEdullisesti(300));
    }

    @Test
    public void VaihtorahaOikeinMaukkaalla() {
        assertEquals(100, paate.syoMaukkaasti(500));
    }

    @Test
    public void KassaKasvaaOikeinEdullisella() {
        assertEquals(100250, paate.kassassaRahaa() + 250);
    }

    @Test
    public void KassaKasvaaOikeinMaukkaalla() {
        assertEquals(100400, paate.kassassaRahaa() + 400);
    }

    @Test
    public void EdullisetKasvavatOikein() {
        paate.syoEdullisesti(250);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void MaukkaatKasvavatOikein() {
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void EdullinenMaksuEiRiittava() {
        paate.syoEdullisesti(100);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void MaukasMaksuEiRiittava() {
        paate.syoMaukkaasti(300);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void VaihtorahaEdullisellaEiRiittavastiRahaa() {
        assertEquals(200, paate.syoEdullisesti(200));
    }

    @Test
    public void VaihtorahaMaukkaallaEiRiittavastiRahaa() {
        assertEquals(250, paate.syoMaukkaasti(250));
    }

    @Test
    public void KassaEiMuutuEdullisellaEiRiitavastiRahaa() {
        assertEquals(100020, paate.kassassaRahaa() + paate.syoEdullisesti(20));
    }

    @Test
    public void KassaEiMuutuMaukkaallaEiRiittavastiRahaa() {
        assertEquals(100030, paate.kassassaRahaa() + paate.syoMaukkaasti(30));
    }

    @Test
    public void KortillaRiittavastiRahaaEdulliseen() {
        assertTrue(paate.syoEdullisesti(kortti));
    }

    @Test
    public void KortillaRiittavastiRahaaMaukkaaseen() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void KortillaRiittavastiRahaaEdullisetKasvavat() {
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void KortillaRiittavastiRahaaMaukkaatKasvavat() {
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void KortillaEiRiittavastiRahaaEdulliseen() {
        assertTrue(!paate.syoEdullisesti(kortti2));
    }

    @Test
    public void KortillaEiRiittavastiRahaaMaukkaaseen() {
        assertTrue(!paate.syoMaukkaasti(kortti2));
    }

    @Test
    public void KortillaEiRiittavastiRahaaEdullisetEivatKasva() {
        paate.syoEdullisesti(kortti2);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void KortillaEiRiittavastiRahaaMaukkaatEivatKasva() {
        paate.syoMaukkaasti(kortti2);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    @Test 
    public void KortillaEiRiittavastiRahaaRahamaaraEiMuutuMaukas() {
        paate.syoMaukkaasti(kortti2);
        assertEquals(5, kortti2.saldo());
    }
    
    @Test 
    public void KortillaEiRiittavastiRahaaRahamaaraEiMuutuEdullinen() {
        paate.syoEdullisesti(kortti2);
        assertEquals(5, kortti2.saldo());
    }
    
    @Test
    public void KassaEiMuutuKortillaOstettaessa() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test 
    public void KortinSaldoMuuttuuRahaaLadattaessa() {
        kortti.lataaRahaa(212);
        assertEquals(1212, kortti.saldo());
    }
    @Test
    public void KassanRahamaaraMuuttuuLadattaessa() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, paate.kassassaRahaa());
    }
    @Test 
    public void KassanRahamaaraEiMuutuLadattaessaNegatiivinen() {
        paate.lataaRahaaKortille(kortti, -5);
        assertEquals(100000, paate.kassassaRahaa());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
