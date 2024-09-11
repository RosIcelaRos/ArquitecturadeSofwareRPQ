/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patronproxy2;

/**
 *
 * @author Jhamil
 */
public class PatronProxy2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario1 = new Usuario("Usuario1", true);  // Con permiso de escritura
        Usuario usuario2 = new Usuario("Usuario2", false);  // Sin permiso de escritura

        // Crear el proxy para el archivo con el usuario 1
        System.out.println("Acceso del Usuario1 al archivo:\n");
        Archivo archivoJuan = new ProxyArchivo("C:\\Users\\Jhamil\\Desktop\\archivo.txt", usuario1.tienePermisoEscritura());
        
        System.out.println("\tLECTURA DEL ARCHIVO POR PARTE DEL USUARIO 1:");
        archivoJuan.leer();  // Puede leer el archivo
        System.out.println("");
        System.out.println("\tINTENTANTO AGREGAR CONTENIDO AL ARCHIVO POR PARTE DEL USUARIO 1:");
        archivoJuan.escribir("Nuevo contenido del Usuario1, CON PERMISOS PARA ESCRIBIR");  // Puede escribir en el archivo

        System.out.println("\nAcceso del Usuario2 al archivo:\n");
        
        Archivo archivoAna = new ProxyArchivo("C:\\Users\\Jhamil\\Desktop\\archivo.txt", usuario2.tienePermisoEscritura());
        System.out.println("\tLECTURA DEL ARCHIVO POR PARTE DEL USUARIO 2:");
        archivoAna.leer();  // Puede leer el archivo
        System.out.println("");
        System.out.println("\tINTENTANTO AGREGAR CONTENIDO AL ARCHIVO POR PARTE DEL USUARIO 2:");
        archivoAna.escribir("Intento del Usuario2 de escribir. SIN PERMISOS PARA ESCRIBIR");  // No tiene permiso para escribir
    }
    
}
