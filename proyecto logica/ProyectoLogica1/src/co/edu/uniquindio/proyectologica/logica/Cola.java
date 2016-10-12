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
public class Cola<T> {

    /**
     * Nodo incial de la Cola
     */
    private NodoD<T> inicio;

    /**
     * Tamaño de la cola
     */
    private int tamanio;

    ////////////////////////////////////////////////////////////
    // Cola - Implementacion de Metodos ////////////////////////
    //////////////////////////////////////////////////////////// 
    /**
     * Constructor de la Clase Cola, por defecto el primer y ultimo nodo es NULL
     * y su tamaño es 0. Se construyo una Cola sin elementos.
     */
    public Cola() {
        this.inicio = new NodoD<T>(null, null, null);
        this.inicio.setSig(inicio);
        inicio.setAnt(inicio);
        this.tamanio = 0;
    }

    /**
     * Metodo que permite agregar un elemento a la Cola. Se inserto un nuevo
     * elemento a la Cola
     *
     * @param info es de tipo T y contiene la informacion a en colar
     */
    public void enColar(T info) {
        NodoD<T> x = new NodoD<T>(info, inicio, inicio.getAnt());
        inicio.getAnt().setSig(x);
        inicio.setAnt(x);
        this.aumentarTamanio();
    }

    /**
     * Metodo que permite retirar el primer elemento que fue insertado en la
     * Cola. Se elimina el primer elemento que fue insertado en la cola.
     *
     * @return un tipo T que contiene la informacion del nodo retirado.
     */
    public T deColar() {
        if (this.esVacia()) {
            return (null);
        }
        NodoD<T> x = this.inicio.getSig();
        this.inicio.setSig(x.getSig());
        x.getSig().setAnt(inicio);
        x.setSig(null);
        x.setAnt(null);
        this.tamanio--;
        return (x.getInfo());
    }

    /**
     * Metodo que permite elimar todos los datos que contiene la Cola. Se
     * elimino todos los datos que se encontraban en la Cola.
     */
    public void vaciar() {
        this.inicio.setSig(this.inicio);
        this.inicio.setAnt(this.inicio);
        this.tamanio = 0;
    }

    /**
     * Metodo que permite conocer el primer elemento que fue insertado en la
     * Cola. Se obtiene el primer elemento que fue insertado en la Cola.
     *
     * @return El primer elemento que fue insertado en la cola
     */
    protected NodoD<T> getInicio() {
        return this.inicio;
    }

    /**
     * Metodo que permite conocer el primer elemento que fue insertado en la
     * Cola. Se obtiene el primer elemento que fue insertado en la Cola.
     *
     * @return El primer elemento que fue insertado en la cola
     */
    public T getInfoInicio() {
        return this.inicio.getSig().getInfo();
    }

    /**
     * Metodo que permite aumentar el tamaño de la Cola para dar uso en Cola de
     * Prioridad.
     */
    protected void aumentarTamanio() {
        this.tamanio++;
    }

    /**
     * Metodo que permite modificar el Nodo inicial de la Cola para uso de la
     * Cola de prioridad.
     *
     * @param ini Representa el nuevo Nodo inicial de la cola.
     */
    protected void setInicio(NodoD<T> ini) {
        this.inicio = ini;
    }

    /**
     * Metodo que retorna el tamaño de la cola. Se retorno el numero de
     * elementos existentes en la Cola.
     *
     * @return un tipo integer qeu contiene el tamaño de la cola
     */
    public int getTamanio() {
        return (this.tamanio);
    }

    /**
     * Metodo que retorna si la cola esta vacia o no Retorna si la Cola se
     * encuentra vacia, retorna false si hay elementos en la Cola.
     *
     * @return un tipo boolean, true si es vacio y false si contiene nodos
     */
    public boolean esVacia() {
        return (this.getTamanio() == 0);
    }

    /**
     * Convierte la pila a una cadena de String. Se retorno la representacion en
     * String de la pila. El String tiene el formato "e1->e2->e3..->en", donde
     * e1, e2, ..., en son los los elementos de la Pila.
     *
     * @return La representacion en String de la Pila.
     */
    @Override
    public String toString() {
        String msj = "";
        NodoD<T> c = this.inicio.getSig();
        while (c != inicio) {
            msj += c.getInfo().toString() + "->";
            c = c.getSig();
        }
        return msj;
    }

}

