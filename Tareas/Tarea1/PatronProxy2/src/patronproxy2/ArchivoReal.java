/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronproxy2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoReal implements Archivo {
    private String nombreArchivo;

    public ArchivoReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void leer() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void escribir(String contenido) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true)) {
            fw.write(contenido + "\n");
            System.out.println("Contenido agregado al archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
