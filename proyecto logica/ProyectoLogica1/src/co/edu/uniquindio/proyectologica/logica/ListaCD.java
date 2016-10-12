/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniquindio.proyectologica.logica;

import java.util.Iterator;

/**
 *
 * @author juan david
 */
public class ListaCD<T> implements Iterable<T> {

    /**
     * Representa el Nodo cabecera de la Lista, no posee informacion
     */
    private NodoD<T> cabeza;

    /**
     * Representa el tamaño de la Lista
     */
    private int tamanio = 0;

    /**
     * Constructor de la Clase Lista Circular Doble Enlazada, Crea un nodo que
     * sirve como cabezaecera de la ListaCD<T>. Se construyo una lista circular
     * doble vacia.
     */
    public ListaCD() {
        this.cabeza = new NodoD<T>(null, null, null);
        this.cabeza.setSig(cabeza);
        cabeza.setAnt(cabeza);
    }

    /**
     * Metodo que permite adicionar un Elemento al Inicio de la Lista. Se
     * inserto un nuevo elemento al inicio de la Lista.
     *
     * @param dato Informacion que desea almacenar en la Lista. La informacion
     * debe ser un Objeto.
     */
    public void insertarAlInicio(T dato) {
        NodoD<T> x = new NodoD<T>(dato, cabeza.getSig(), cabeza);
        cabeza.setSig(x);
        x.getSig().setAnt(x);
        this.tamanio++;
    }

    /**
     * Metodo que permite insertar un Elemento al Final de la Lista. Se inserto
     * un nuevo elemento al final de la Lista.
     *
     * @param dato Informacion que desea almacenar en la Lista. La informacion
     * debe ser un Objeto.
     */
    public void insertarAlFinal(T dato) {
        NodoD<T> x = new NodoD<T>(dato, cabeza, cabeza.getAnt());
        cabeza.getAnt().setSig(x);
        cabeza.setAnt(x);
        this.tamanio++;
    }

    /**
     * Metodo que inserta un Elemento de manera Ordenada desde la cabeza de la
     * Lista. Se inserto un nuevo elemento en la posicion segun el Orden de la
     * Lista.
     *
     * @param info Información que desea almacenar en la Lista de manera
     * Ordenada.
     */
    public void insertarOrdenado(T info) {
        if (this.esVacia()) {
            this.insertarAlInicio(info);
        } else {
            NodoD<T> x = this.cabeza;
            NodoD<T> y = x;
            x = x.getSig();
            while (x != this.cabeza) {
                Comparable comparador = (Comparable) info;
                int rta = comparador.compareTo(x.getInfo());
                if (rta < 0) {
                    break;
                }
                y = x;
                x = x.getSig();
            }
            if (x == cabeza.getSig()) {
                this.insertarAlInicio(info);
            } else {
                y.setSig(new NodoD<T>(info, x, y));
                x.setAnt(y.getSig());
                this.tamanio++;
            }
        }
    }

    /**
     * Metodo que permite eliminar un elemento de la lista dada una posicion.
     *
     * Se elimino el dato en la posicion indicada de la lista.
     *
     * @param i Posicion del objeto
     * @return el objeto que se elimino de la lista
     */
    public T eliminar(int i) {
        try {
            NodoD<T> x;
            if (i == 0) {
                x = this.cabeza.getSig();
                this.cabeza.setSig(x.getSig());
                this.cabeza.getSig().setAnt(this.cabeza);
                x.setSig(null);
                x.setAnt(null);
                this.tamanio--;
                return (x.getInfo());
            }
            x = this.getPos(i - 1);
            if (x == null) {
                return (null);
            }
            NodoD<T> y = x.getSig();
            x.setSig(y.getSig());
            y.getSig().setAnt(x);
            y.setSig(null);
            y.setAnt(null);
            this.tamanio--;
            return (y.getInfo());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return (null);
    }

    /**
     * Metodo que elimina todos los datos de la Lista Circular Doble. Elimina
     * todos los datos que contenga la lista circular doble.
     */
    public void vaciar() {
        this.cabeza = new NodoD<T>(null, null, null);
        this.cabeza.setSig(cabeza);
        cabeza.setAnt(cabeza);
        this.tamanio = 0;
    }

    /**
     * Metodo que retorna el objeto de la posicion i. Se retorno el elemento
     * indicado por la posicion recibida i.
     *
     * @param i posicion de un elemento de la lista
     * @return Devuelve el Objeto de la posicion especificada , null en caso
     * contrario
     */
    public T get(int i) {
        try {
            NodoD<T> x = this.getPos(i);
            if (x == null) {
                return (null);
            }
            return (x.getInfo());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return (null);
    }

    /**
     * Metodo que modifica el elemento que se encuentre en una posicion dada.
     *
     * Se edito el elemento indicado en la posicion indicada.
     *
     * @param i Una Posicion dentro de la Lista
     * @param dato es el nuevo valor que toma el elmento en la lista
     */
    public void set(int i, T dato) {
        try {
            NodoD<T> t = this.getPos(i);
            if (t != null) {
                t.setInfo(dato);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Metodo que permite conocer el tamaño de la lista. Se retorno el numero de
     * elementos existentes en la Lista.
     *
     * @return un int con el tamaño de la lista
     */
    public int getTamanio() {
        return (this.tamanio);
    }

    /**
     * Metodo que permite conocer si en la lista se encuentra elementos. Se
     * retorno true si la lista no contiene elementos.
     *
     * @return un boolean true si la lista esta vacia, false en caso contrario
     */
    public boolean esVacia() {
        return (cabeza == cabeza.getSig() || this.getTamanio() == 0);
    }

    /**
     * Metodo que permite buscar un elemento en la lista si lo encuentra retorna
     * true, de lo contrario false. 
     * Se retorno true si el elemento se encuentra en la
     * Lista.
     *
     * @param info el cual contiene el valor del parametro a buscar en la lista
     * 
     * @return un boolean, si es true encontro el dato en la lista y si es false
     * no.
     */
    public boolean esta(T info) {
        return (this.getIndice(info) != -1);
    }

    /**
     * Metodo que permite retornar la informacion de una Lista en un Vector.
     * 
     *
     * @return Un vector de Objetos con la informacion de cada posicion de la
     * Lista.
     */
    public Object[] aVector() {
        if (this.esVacia()) {
            return (null);
        }
        Object vector[] = new Object[this.getTamanio()];
        Iterator<T> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            vector[i++] = it.next();
        }
        return (vector);
    }

    /**
     * Metodo que permite retornar toda la informacion de los elementos de la
     * Lista Circular Doble en un String. 
     * Retorna la impresion de los datos de la lista Circular
     * Doble en un String. 
     * El String tiene el formato "e1->e2->e3..->en", donde e1, e2, ..., en son
     * los los elementos de la Lista Circular Doble. 
     *
     * @return Un String con los datos de los elementos de la Lista
     */
    @Override
    public String toString() {
        if (this.esVacia()) {
            return ("Lista Vacia");
        }
        String r = "";
        for (NodoD<T> x = this.cabeza.getSig(); x.getInfo() != null; x = x.getSig()) {
            r += x.getInfo().toString() + "<->";
        }
        return (r);
    }

    /**
     * Metodo de tipo private, que retorna un nodo con la posicion de este en la
     * lista y ejecuta una exception si sucede un error.
     *
     * @param i es de tipo integer y contiene la posicion del elemento en la
     * lista. 
     * @return un tipo NodoD<T> con el nodo de la posicion
     */
    @SuppressWarnings("empty-statement")
    private NodoD<T> getPos(int i) throws Exception {
        if (i < 0 || i >= this.tamanio) {
            System.err.println("Error indice no valido en una Lista Circular Doblemente Enlazada");
            return (null);
        }
        NodoD<T> x = cabeza.getSig();
        for (; i-- > 0; x = x.getSig());
        return x;
    }

    /**
     * Metodo que busca un elemento de la lista y devuelve su posicion.Los
     * objetos que se almacenan en la lista deben tener el Método equals.
     *  Retorna el Nodo que se encuentra en esa posicion indicada.
     * 
     *
     * @param dato de tipo T que indica la informacion del nodo a buscar 
     * @return un entero que representa la posicion del objeto consultado en la
     * lista
     */
    public int getIndice(T dato) {
        int i = 0;
        for (NodoD<T> x = this.cabeza.getSig(); x != this.cabeza; x = x.getSig()) {
            if (x.getInfo().equals(dato)) {
                return (i);
            }
            i++;
        }
        return (-1);
    }

    @Override
    public Iterator<T> iterator() {
        return (new IteratorLCD<T>(this.cabeza));
    }

}
