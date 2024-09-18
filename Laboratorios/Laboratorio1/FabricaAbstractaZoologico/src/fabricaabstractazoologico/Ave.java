/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaabstractazoologico;

/**
 *
 * @author VICTUS
 */
public abstract class Ave implements Animal {
    private String nombre;
    private double peso;
    private double tamañoAlas;

    public Ave(String nombre, double peso, double tamañoAlas) {
        this.nombre = nombre;
        this.peso = peso;
        this.tamañoAlas = tamañoAlas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTamañoAlas() {
        return tamañoAlas;
    }

    public void setTamañoAlas(double tamañoAlas) {
        this.tamañoAlas = tamañoAlas;
    }

    public void volar() {
        System.out.println(nombre + " está volando.");
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ave: " + nombre + ", Peso: " + peso + "kg, Tamaño de alas: " + tamañoAlas + "m";
    }
}

