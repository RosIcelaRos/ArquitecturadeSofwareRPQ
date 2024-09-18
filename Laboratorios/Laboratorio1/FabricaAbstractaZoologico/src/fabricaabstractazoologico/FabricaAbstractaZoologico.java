/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabricaabstractazoologico;

import java.util.Scanner;

/**
 *
 * @author VICTUS
 */
public class FabricaAbstractaZoologico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricaAbstractaAnimal fabrica = new FabricaAnimal();
        Zoologico zoo = Zoologico.getInstance("Zoo Nacional", "Av. Animales 123", "74701865");

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 8) {
            System.out.println("\nMenu:");
            System.out.println("1. Aniadir Mamífero");
            System.out.println("2. Aniadir Ave");
            System.out.println("3. Aniadir Pez");
            System.out.println("4. Mostrar Mamiferos");
            System.out.println("5. Mostrar Aves");
            System.out.println("6. Mostrar Peces");
            System.out.println("7. Mostrar Zoologico");
            System.out.println("8. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Añadir Ave:");
                    System.out.print("Nombre: ");
                    String nombreMam = scanner.next();
                    System.out.print("Temperatura: ");
                    double temp = scanner.nextDouble();
                    System.out.print("Número de patas: ");
                    int patas = scanner.nextInt();
                    System.out.print("Color: ");
                    String color = scanner.next();
                    Mamifero mamifero = fabrica.crearMamifero(nombreMam, temp, patas, color);
                    zoo.addJaula(new Jaula(mamifero, 5, 5, 5));
                    break;
                case 2:
                    System.out.println("Añadir Mamífero:");
                    System.out.print("Nombre: ");
                    String nombreAve = scanner.next();
                    System.out.print("Peso: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Tamaño alas: ");
                    int tamanioAlas = scanner.nextInt();
                    
                    Ave ave = fabrica.crearAve(nombreAve, peso, tamanioAlas);
                    zoo.addJaula(new Jaula(ave, 5, 5, 5));
                    break;
                
                case 3:
                    System.out.println("Añadir Pez:");
                    System.out.print("Nombre: ");
                    String nombrePez = scanner.next();
                    System.out.print("Longitud: ");
                    double longitud = scanner.nextDouble();
                    
                    
                    Pez pez = fabrica.crearPez(nombrePez, longitud);
                    zoo.addJaula(new Jaula(pez, 5, 5, 5));
                    break;
                case 4:
                    zoo.mostrarAnimalesPorTipo(Mamifero.class);
                    break;
                case 5:
                    zoo.mostrarAnimalesPorTipo(Ave.class);
                    break;
                case 6:
                    zoo.mostrarAnimalesPorTipo(Pez.class);
                    break;
                case 7:
                    zoo.mostrarZoologico();
                    break;

            }
        }
    }
}
