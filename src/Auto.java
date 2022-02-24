public class Auto {
    String type;
    double prijsPerDag;

    public Auto(String tp, double prPD) {
        type = tp;
        prijsPerDag = prPD;
    }

    public void setPrijsPerDag(double prPD) {
        prijsPerDag = prPD;
    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    public String toString() {
        return type + " met prijs per dag: " + prijsPerDag;
    }
}
