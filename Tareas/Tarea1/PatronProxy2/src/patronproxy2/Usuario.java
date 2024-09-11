/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronproxy2;

/**
 *
 * @author Jhamil
 */
public class Usuario {
    private String nombre;
    private boolean permisoEscritura;

    public Usuario(String nombre, boolean permisoEscritura) {
        this.nombre = nombre;
        this.permisoEscritura = permisoEscritura;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tienePermisoEscritura() {
        return permisoEscritura;
    }
}
