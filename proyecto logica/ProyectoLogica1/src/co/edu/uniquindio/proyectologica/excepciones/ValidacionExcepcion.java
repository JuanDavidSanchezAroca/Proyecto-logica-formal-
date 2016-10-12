package co.edu.uniquindio.proyectologica.excepciones;
/**
 * Excepcion de error de validacion
 *
 * @author juan David Sanchez Aroca,ccardona, cpacheco
 * @version 1.0
 */
public class ValidacionExcepcion extends Exception {
    /**
     * Constructor de la clase excepcion de validacion
     */
    public ValidacionExcepcion() {
        super("la formula no se encuentra bien formada");
    }//Cierre del constructor    
}
