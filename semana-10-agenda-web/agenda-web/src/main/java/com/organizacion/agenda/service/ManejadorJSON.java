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
public class ManejadorJSON<T> {
    private final Gson gson;
    private final String rutaArchivo;
    private final Type tipoLista;
    
    public ManejadorJSON(Class<T> clase ,String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
        this.tipoLista = TypeToken.getParameterized(ArrayList.class, clase).getType();
    }

    public void guardar(List<T> lista){
        try (FileWriter writer = new FileWriter(this.rutaArchivo)){
            gson.toJson(lista, writer);
        } catch (IOException e){
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public List<T> cargar(){
        File archivo = new File(this.rutaArchivo);

        if(!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(archivo)) {
            
            List<T> lista =gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();

        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
