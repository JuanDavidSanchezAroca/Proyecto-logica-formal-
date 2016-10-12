/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniquindio.proyectologica.excepciones;

/**
 * Esta es la clase donde inplementamos una exepcion 
 * personalizada, donde identificamos que la altura del arbol
 * no sobrepase de la altura maxima de 6 niveles
 *  
 * @author Juan David Espitia
 * @author Juan David Sanchez
 * @author Esteban Mauricio Casta�o
 */
public class AlturaException extends Exception{

    public AlturaException() {
        super("altura maxima alcanzada de 6 ");
    }
    
    
}
