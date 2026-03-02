package modelo;

public class Auto extends Vehiculo {

    private int numeroPuertas;

    public Auto(String marca, String modelo, int anio, int puertas) {
        super(marca, modelo, anio);
        this.numeroPuertas = puertas;
    }

    @Override
    public void acelerar() {
        System.out.println(marca + " (auto) acelera.");
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }
}