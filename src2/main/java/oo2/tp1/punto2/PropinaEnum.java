package oo2.tp1.punto2;

public enum PropinaEnum {
    DOS(0.02),
    TRES(0.03),
    CINCO(0.05);

    private double porcentaje;

    PropinaEnum(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
 