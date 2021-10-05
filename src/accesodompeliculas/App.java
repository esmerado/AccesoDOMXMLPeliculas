/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodompeliculas;

import java.io.File;

/**
 *
 * @author esmer
 */
public class App {
    
    public static void main(String[] args) {
        
        // Creamos el objeto con la ruta del nuestro XML.
        File f = new File("src/xml/Pelis.xml");
       
        // Creamos la instancia de nuestra clase.
        AccesoDomPeliculas adp = new AccesoDomPeliculas();
       
        // Llamamos al método.
        adp.openXML(f);
       
        // Guardamos en un string nuestro DOM.
        String datos = adp.showDOM();
       
        // Mostramos los datos.
        System.out.println(datos);
        
    }
        
        
    
}
