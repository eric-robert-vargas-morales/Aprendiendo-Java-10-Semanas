package com.tlaprendizaje.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tlaprendizaje.modelo.Contacto;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {
    private static final Gson gson = new GsonBuilder()
                                        .setPrettyPrinting()
                                        .create();

    public static void guardar(ArrayList<Contacto> lista, String rutaArchivo){
        try (FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(lista, writer);
        } catch (IOException e){
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public static ArrayList<Contacto> cargar(String rutaArchivo){
        File archivo = new File(rutaArchivo);

        if(!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(archivo)) {
            Type tipo = new TypeToken<ArrayList<Contacto>>(){}.getType();
            ArrayList<Contacto> lista =gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();

        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
