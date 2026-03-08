package servicio;

import modelo.Estudiante;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;
public class GestorEstudiantes {

    private HashMap<String, Estudiante> porCarnet;
    private TreeSet<Estudiante> ranking;
    private ArrayList<String> historial;

    public GestorEstudiantes(){
        porCarnet=new HashMap<>();
        ranking=new TreeSet<>();
        historial=new ArrayList<>();

    }

}