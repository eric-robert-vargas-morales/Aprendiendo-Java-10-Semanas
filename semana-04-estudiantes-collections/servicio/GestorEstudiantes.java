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
        public boolean agregar(Estudiante e){
        if(porCarnet.containsKey(e.getCarnet())){
            return false;
        }
        porCarnet.put(e.getCarnet(), e);
        ranking.add(e);
        historial.add("AGREGAR : " +e.getCarnet() + " - " + e.getNombre());
        return true;
    }

    public Estudiante buscar(String carnet){
        return porCarnet.get(carnet);
    }

    public boolean actualizarPromedio(String carnet, double nuevoProm){
        Estudiante e= porCarnet.get(carnet);
        if(e==null)
            return false;
        ranking.remove(e);
        e.setPromedio(nuevoProm);
        ranking.add(e);

        historial.add("ACTUALIZAR: " + carnet + " promedio -> " + nuevoProm);
        return true;
    }
    
    public boolean eliminar(String carnet){
        Estudiante e=porCarnet.remove(carnet);
        if(e==null)
            return false;
        ranking.remove(e);
        historial.add("ELIMINAR: " + carnet + " - " + e.getNombre());
        return true;
    }

}