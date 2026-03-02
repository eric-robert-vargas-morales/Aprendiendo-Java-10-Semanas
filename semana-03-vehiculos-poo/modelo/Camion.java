package modelo;

public class Camion extends Vehiculo {
    private double capacidadToneladas;

    public Camion(String marca, String modelo, int anio, double ton) {
        super(marca, modelo, anio);
        this.capacidadToneladas = ton;
    }

    @Override
    public void acelerar() {
        System.out.println(marca + " (camion, " 
            + capacidadToneladas + "t) acelera despacio.");
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }
}