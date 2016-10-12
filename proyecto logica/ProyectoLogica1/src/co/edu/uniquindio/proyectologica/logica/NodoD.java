/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniquindio.proyectologica.logica;

/**
 *
 * @author juan david
 */
public class NodoD<T> {

    /**
     * Informacion del Nodo
     */
    private T info;

    /**
     * Nodo Anterior
     */
    private NodoD<T> ant;

    /**
     * Nodo Siguiente
     */
    private NodoD<T> sig;

    /**
     * Constructor de un Nodo Doble vacio. Se construyo un Nodo Doble vacio con
     * la informacion en NULL.
     */
    public NodoD() {
        this.info = null;
        this.ant = null;
        this.sig = null;
    }

    /**
     * Constructor con parametros de la clase NodoD Se construyo un nodo doble
     * con los datos especificados.<br>
     *
     * @param info de tipo T y contiene la informacion del nodo
     * @param sig es del tipo NodoD<T> y contiene la direccion del Nodo
     * siguiente
     * @param ant es de tipo NodoD<T> y contiene la direccion del Nodo anterior
     */
    public NodoD(T info, NodoD<T> sig, NodoD<T> ant) {
        this.info = info;
        this.sig = sig;
        this.ant = ant;
    }

    /**
     * Metodo que permite obtener el contenido del Nodo doble Se retorno la
     * informacion del Nodo doble.
     *
     * @return un tipo T que contiene la informacion del Nodo doble
     */
    protected T getInfo() {
        return (this.info);
    }

    /**
     * Metodo que permite obtener la dirección del Nodo anterior al actual Se
     * retorno la informacion del Nodo anterior al actual.
     *
     * @return un Nodo<T> que contiene
     */
    protected NodoD<T> getAnt() {
        return (this.ant);
    }

    /**
     * Metodo que permite devolver el nodo siguiente al que apunta el Nodo doble
     * Se retorno la informacion del Nodo siguiente al actual.
     *
     * @return un tipo NodoD<T> que contiene el nodo siguiente
     */
    protected NodoD<T> getSig() {
        return (this.sig);
    }

    /**
     * Metodo que permite cambiar la informacion contenida en el Nodo doble Se
     * edito la informacion del Nodo Doble.
     *
     * @param info es de tipo T y contiene la informacion nueva del nodo dooble
     */
    protected void setInfo(T info) {
        this.info = info;
    }

    /**
     * Metodo que permite editar la dirección del nodo anterior por una nueva Se
     * edito la informacion del Nodo anterior del nodo actual.
     *
     *
     * @param ant es de tipo NodoD<T> y contiene la nueva dirección del nodo
     * anterior
     */
    protected void setAnt(NodoD<T> ant) {
        this.ant = ant;
    }

    /**
     * Metodo que permite cambiar el nodo siguiente del Nodo doble actual Se
     * edito la informacion del Nodo siguiente del nodo actual.
     *
     *
     * @param sig es de tipo NodoD<T> y contien la informacion del nuevo nodo
     * siguiente
     */
    protected void setSig(NodoD<T> sig) {
        this.sig = sig;
    }
}

