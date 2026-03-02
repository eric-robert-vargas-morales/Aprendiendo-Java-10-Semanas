package modelo;

public class AutoElectrico extends Auto implements Electrico {

    private int nivelBateria;

    public AutoElectrico(String marca, String modelo, int anio, int puertas, int bateria) {
        super(marca, modelo, anio, puertas);
        this.nivelBateria = bateria;
    }

    @Override
    public void cargarBateria() {
        nivelBateria = 100;
        System.out.println(marca + " cargado al 100%.");
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
        if (nivelBateria > 0) {
            nivelBateria -= 5;
            System.out.println(marca + " (electrico) acelera. Bateria: " + nivelBateria + "%");
        } else {
            System.out.println(marca + " sin bateria, no puede acelerar.");
        }
    }
}