public class Klant {
    String naam = null;
    double kortingsPercentage;

    public Klant(String nm) {
        naam = nm;
    }

    public void setKorting(double kP) {
        kortingsPercentage = kP;
    }

    public double getKorting() {
        return kortingsPercentage;
    }

    public String toString() {
        return naam + " (korting: " + kortingsPercentage + ")\n";
    }
}
