/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronproxy2;

/**
 *
 * @author Jhamil
 */
public class ProxyArchivo implements Archivo {
    private ArchivoReal archivoReal;
    private String nombreArchivo;
    private boolean tienePermisoEscritura;

    public ProxyArchivo(String nombreArchivo, boolean tienePermisoEscritura) {
        this.nombreArchivo = nombreArchivo;
        this.tienePermisoEscritura = tienePermisoEscritura;
    }

    @Override
    public void leer() {
        if (archivoReal == null) {
            archivoReal = new ArchivoReal(nombreArchivo);
        }
        archivoReal.leer();
    }

    @Override
    public void escribir(String contenido) {
        if (!tienePermisoEscritura) {
            System.out.println("No tiene permisos para escribir en el archivo.");
        } else {
            if (archivoReal == null) {
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            archivoReal.escribir(contenido);
        }
    }
}

