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
    void testKorting() {
        double zonderKorting;
        double metKorting;
        Klant f = new Klant("Test Klant");
        Auto p = new Auto("test Auto", 50);
        aH.setAantalDagen(2);
        f.setKorting(50);
        aH.setHuurder(f);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        metKorting = aH.totaalPrijs();
        Klant g = new Klant("Zonder Korting");
        aH.setHuurder(g);
        zonderKorting = aH.totaalPrijs();
        assertEquals(metKorting, zonderKorting / 2);
    }

    @Test
    void stringKorting() {
        AutoHuur verhuurTest = new AutoHuur();
        Klant f = new Klant("Test Klant");
        f.setKorting(50);
        Klant g = new Klant("Zonder Korting");
        Auto p = new Auto("test Auto", 50);
        p.setPrijsPerDag(50);
        aH.setGehuurdeAuto(p);
        verhuurTest.setGehuurdeAuto(p);
        aH.setAantalDagen(2);
        verhuurTest.setAantalDagen(2);
        aH.setHuurder(f);
        verhuurTest.setHuurder(g);
        if (aH.toString().contains(String.valueOf(aH.totaalPrijs())) && verhuurTest.toString().contains(String.valueOf(verhuurTest.totaalPrijs()))) {
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