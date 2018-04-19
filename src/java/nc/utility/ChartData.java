package nc.utility;

public class ChartData {
    
    private final String etichetta;
    private double valD;
    private int valI;

    public ChartData(String etichetta, int valI) {
        this.etichetta = etichetta;
        this.valI = valI;
    }

    public ChartData(String etichetta, double valD) {
        this.etichetta = etichetta;
        this.valD = valD;
    }

    public String getEtichetta() {
        return etichetta;
    }

    public double getValD() {
        return valD;
    }

    public int getValI() {
        return valI;
    }
    
}
