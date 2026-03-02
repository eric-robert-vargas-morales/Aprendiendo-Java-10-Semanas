package modelo;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, String modelo, int anio, boolean sidecar) {
        super(marca, modelo, anio);
        this.tieneSidecar = sidecar;
    }

    @Override
    public void acelerar() {
        System.out.println(marca + " (moto) acelera ligero.");
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
}