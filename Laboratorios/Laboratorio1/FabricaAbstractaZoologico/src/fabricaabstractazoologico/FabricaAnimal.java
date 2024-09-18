/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaabstractazoologico;

/**
 *
 * @author VICTUS
 */
public class FabricaAnimal implements FabricaAbstractaAnimal {

    

    @Override
    public Mamifero crearMamifero(String nombre, double temperatura, int nroDePatas, String color) {
        return new Mamifero(nombre, temperatura, nroDePatas, color) {};
    }

    @Override
    public Ave crearAve(String nombre, double peso, double tamañoAlas) {
        return new Ave(nombre, peso, tamañoAlas) {};
    }

    @Override
    public Pez crearPez(String nombre, double longitud) {
        return new Pez(nombre, longitud) {};
    }
}

