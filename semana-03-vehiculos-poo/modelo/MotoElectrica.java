package modelo;

public class MotoElectrica extends Moto implements Electrico {

    private int nivelBateria;

    public MotoElectrica(String marca, String modelo, int anio, int bateria) {
        super(marca, modelo, anio, false);
        this.nivelBateria = bateria;
    }

    @Override
    public void cargarBateria() {
        nivelBateria = 100;
        System.out.println(marca + " (moto electrica) cargada.");
    }

    @Override
    public int getNivelBateria() {
        return nivelBateria;
    }

    @Override
    public boolean necesitaCarga() {
        return nivelBateria < 20;
    }

    @Override
    public void acelerar() {
        nivelBateria -= 3;
        System.out.println(marca + " (moto electrica) acelera. Bateria: " + nivelBateria + "%");
    }
}