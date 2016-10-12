/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.proyectologica.excepciones;

/**
 * Esta es la clase que me identifica una exepcion 
 * personaliza que me indica que el nodo que se esta
 * agregando no posse padre
 * 
 * @author Juan David Espitia
 * @author Juan David Sanchez
 * @author Esteban Mauricio Casta�o
 */
public class NoTienePadreException extends Exception {

    /**
     * Constructor de la clase
     */
    public NoTienePadreException() {
        super("el nodo a agregar no tiene padre");
    }

}
