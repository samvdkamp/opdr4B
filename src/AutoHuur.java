public class AutoHuur {
    int aantalDagen;
    Klant huurder = null;
    Auto gehuurdeAuto = null;

    public AutoHuur() {
    }

    public void setAantalDagen(int aD) {
        aantalDagen = aD;
    }

    public int getAantalDagen() {
        return aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        huurder = k;
    }

    public Klant getHuurder() {
        return huurder;
    }

    public double totaalPrijs() {
        double korting = 0;
        if (huurder != null) {
            korting = huurder.kortingsPercentage;
        }
        if (gehuurdeAuto == null) {
            return 0;
        } else {
            return gehuurdeAuto.getPrijsPerDag() * aantalDagen * (1 - (korting) / 100);
        }
    }

    public String toString() {
        if (huurder == null && gehuurdeAuto == null) {
            return "er is geen auto bekend\ner is geen huurder bekend\naantal dagen: 0 en dat kost 0.0";
        } else if (gehuurdeAuto == null) {
            return "er is geen auto bekend\n" + "op naam van:" + getHuurder() + "aantal dagen: " + aantalDagen + " en dat kost: " + totaalPrijs() + "\n";
        } else if (huurder == null) {
            return "autotype: " + getGehuurdeAuto() + "\ner is geen huurder bekend" + "\naantal dagen: " + aantalDagen + " en dat kost: " + totaalPrijs();
        } else {
            return "autotype: " + getGehuurdeAuto() + "\nop naam van:" + getHuurder() + "aantal dagen: " + aantalDagen + " en dat kost: " + totaalPrijs() + "\n";

        }
    }
}



