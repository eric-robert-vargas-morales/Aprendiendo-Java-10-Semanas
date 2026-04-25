package com.organizacion.agenda.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.reflect.Type;
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

    public static void guardar(List<Contacto> lista){
        try (FileWriter writer = new FileWriter(this.rutaArchivo)){
            gson.toJson(lista, writer);
        } catch (IOException e){
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public static List<Contacto> cargar(){
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
    public static void hacerBackup(String rutaOriginal, String rutaBackup) {
        File original = new File(rutaOriginal);
        if (!original.exists()) return;

        try (FileReader reader = new FileReader(original);
            FileWriter writer = new FileWriter(rutaBackup)){
            int caracter;
            while((caracter = reader.read()) != -1) {
                writer.write(caracter);
            }
        } catch (IOException e) {
            System.out.println("No se pudo hacer backup: " + e.getMessage());

        }
    }

    public static void guardarConBackup(ArrayList<Contacto> lista, String rutaArchivo, String rutaBackup) {
        hacerBackup(rutaArchivo, rutaBackup);
        guardar(lista, rutaArchivo);
    }
}
