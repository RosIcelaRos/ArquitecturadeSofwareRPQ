/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaabstractazoologico;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private static Zoologico instancia;
    private String nombre;
    private List<Jaula> jaulas;
    private String direccion;
    private String telefono;

    private Zoologico(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.jaulas = new ArrayList<>();
    }

    public static Zoologico getInstance(String nombre, String direccion, String telefono) {
        if (instancia == null) {
            instancia = new Zoologico(nombre, direccion, telefono);
        }
        return instancia;
    }

    public void addJaula(Jaula jaula) {
        jaulas.add(jaula);
    }

    @Override
    public String toString() {
        return "Zoológico: " + nombre + " en " + direccion + ", Teléfono: " + telefono + "\nJaulas: " + jaulas;
    }
    
    public void mostrarZoologico() {
        System.out.println("Zoológico: " + nombre + "\nDirección: " + direccion + "\nTeléfono: " + telefono);
        for (Jaula jaula : jaulas) {
            System.out.println(jaula);
        }
    } 
    public void mostrarAnimalesPorTipo(Class<? extends Animal> tipo) {
        for (Jaula jaula : jaulas) {
            if (tipo.isInstance(jaula.getAnimal())) {
                System.out.println(jaula.getAnimal());
            }
        }
    }
}

