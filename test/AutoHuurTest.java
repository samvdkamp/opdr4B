import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutoHuurTest {
    AutoHuur aH;
    Klant f;
    Auto p;

    @BeforeEach
    public void init() {
        System.out.println("init");
        aH = new AutoHuur();
    }

    @Test
    void testmetKorting() {
        Klant f = new Klant("Test Klant");
        Auto p = new Auto("test Auto", 50);
        aH.setAantalDagen(2);
        f.setKorting(50);
        aH.setHuurder(f);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        assertEquals(aH.totaalPrijs(), 50);
    }

    @Test
    void testZonderKorting() {
        Klant f = new Klant("Test Klant");
        Auto p = new Auto("test Auto", 50);
        aH.setAantalDagen(2);
        aH.setHuurder(f);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        assertEquals(aH.totaalPrijs(), 100);
    }

    @Test
    void stringmetKorting() {
        Klant f = new Klant("Test Klant");
        f.setKorting(50);
        Auto p = new Auto("test Auto", 50);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        aH.setAantalDagen(2);
        aH.setHuurder(f);
        if (aH.toString().contains(String.valueOf(50))) {
            assertTrue(true);
        } else {
            assertEquals(1, 3);
        }
    }

    @Test
    void stringZonderKorting() {
        Klant f = new Klant("Test Klant");
        Auto p = new Auto("test Auto", 50);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        aH.setAantalDagen(2);
        aH.setHuurder(f);
        if (aH.toString().contains(String.valueOf(100))) {
            assertTrue(true);
        } else {
            assertEquals(1, 3);
        }
    }

    @Test
    void geenAutoGeenHuurder() {
        String test = "er is geen auto bekend\ner is geen huurder bekend\naantal dagen: 0 en dat kost 0.0";
        assertEquals(test, aH.toString());
    }

    @Test
    void geenHuurder() {
        p = new Auto("Auto", 5);
        aH.setGehuurdeAuto(p);
        String test = "autotype: " + aH.getGehuurdeAuto() + "\ner is geen huurder bekend" + "\naantal dagen: " + aH.aantalDagen + " en dat kost: " + aH.totaalPrijs();
        assertEquals(test, aH.toString());
    }

    @Test
    void geenAuto() {
        f = new Klant("Bernie");
        aH.setHuurder(f);
        String test = "er is geen auto bekend\n" + "op naam van:" + aH.getHuurder() + "aantal dagen: " + aH.aantalDagen + " en dat kost: " + aH.totaalPrijs() + "\n";
        assertEquals(test, aH.toString());
    }


}
