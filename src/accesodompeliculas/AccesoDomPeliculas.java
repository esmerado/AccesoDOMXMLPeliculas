/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodompeliculas;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author esmer
 */
public class AccesoDomPeliculas {

    // Obtenemos el árbol DOM
    private Document document;

    /**
     *
     * Clase encargada de abrir el documento XML.
     *
     * @param file
     * @return
     */
    public int openXML(File file) {
        document = null;

        try {
            // Creamos objeto de la clase DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // Especificamos que ignoramos los comentarios que haya en nuestro XML.
            dbf.setIgnoringComments(true);

            // Especificamos que ignoramos los espacios en blanco que haya en nuestro XML.
            dbf.setIgnoringElementContentWhitespace(true);

            // Validamos el código.
            dbf.setValidating(false);

            // Creamos el objeto de la clase DocumentBuilder.
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Especificamos el fichero que queremos parsear
            document = db.parse(file);

            return 0;

        } catch (Exception e) {

            e.printStackTrace();

            return -1;
        }
    }

    public String showDOM() {

        // Creamos array de strings.
        String datos[] = null;

        // Creamos una variable vacía.
        String info = "";

        // Creamos variable node.
        Node node;

        // Obtenemos los nodos raiz.
        Node nodoRaiz = document.getFirstChild();

        //Obtenemos los hijos de los nodos.
        NodeList nodoHijos = nodoRaiz.getChildNodes();

        // Iteramos
        for (int i = 0; i < nodoHijos.getLength(); i++) {
            node = nodoHijos.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                datos = procesarPelis(node);
                info = info + "\n Tipo:  " + datos[0]
                        + "\n Título : " + datos[1]
                        + "\n Productora : " + datos[2]
                        + "\n Duración : " + datos[3]
                        + "\n -----------------------";
            }
            node.getTextContent();
        }
        return info;
    }
    
    public String[] procesarPelis(Node node) {

        // Creación de un array de Strings
        String[] pelis = new String[4];
        
        Node nula = null;
        
        int contador = 1;

        // Comprobamos si tiene atributos.
        if(node.hasAttributes() == false) {
            pelis[0] = "";
        }else {
            pelis[0] = node.getAttributes().item(0).getNodeValue();
        }
        

        // Obtenemos los hijos
        NodeList nodos = node.getChildNodes();
        
        for (int i = 0; i < nodos.getLength(); i++) {
            nula = nodos.item(i);

            if (nula.getNodeType() == Node.ELEMENT_NODE) {

                pelis[contador] = nula.getChildNodes().item(0).getNodeValue();
                contador++;
            }
        }

        return pelis;

    }
    
}
