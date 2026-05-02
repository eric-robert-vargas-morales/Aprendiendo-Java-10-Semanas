package com.organizacion.agenda.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.organizacion.agenda.modelo.Contacto;
public class ManejadorJSON {
    private final Gson gson;
    private final String rutaArchivo;
    
    public ManejadorJSON(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
    }

    public void guardar(List<Contacto> lista){
        try (FileWriter writer = new FileWriter(this.rutaArchivo)){
            gson.toJson(lista, writer);
        } catch (IOException e){
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public List<Contacto> cargar(){
        File archivo = new File(this.rutaArchivo);

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
