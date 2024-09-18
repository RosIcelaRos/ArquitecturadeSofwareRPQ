/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fabricaabstractazoologico;

/**
 *
 * @author VICTUS
 */
public interface FabricaAbstractaAnimal {
    Mamifero crearMamifero(String nombre, double temperatura, int nroDePatas, String color);
    Ave crearAve(String nombre, double peso, double tamañoAlas);
    Pez crearPez(String nombre, double longitud);
}
