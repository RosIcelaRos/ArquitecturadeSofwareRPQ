/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaabstractazoologico;

/**
 *
 * @author VICTUS
 */
public abstract class Mamifero implements Animal {
    private String nombre;
    private double temperatura;
    private int nroDePatas;
    private String color;

    public Mamifero(String nombre, double temperatura, int nroDePatas, String color) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.nroDePatas = nroDePatas;
        this.color = color;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getNroDePatas() {
        return nroDePatas;
    }

    public void setNroDePatas(int nroDePatas) {
        this.nroDePatas = nroDePatas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Mamífero: " + nombre + ", Temperatura: " + temperatura + "°C, Patas: " + nroDePatas + ", Color: " + color;
    }
}

