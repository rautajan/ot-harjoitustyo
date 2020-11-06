package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLatausKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(5);
        assertEquals("saldo: 0.15", kortti.toString());
    }
    
    @Test
    public void negatiivinenLatausEiOnnistu() {
        kortti.lataaRahaa(-2);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.05", kortti.toString());
        
    }
    
    @Test
    public void saldoEiMuutuJosEiRahaa() {
        kortti.otaRahaa((11));
        assertTrue(kortti.saldo()==10);
    }
    
 
}
        
