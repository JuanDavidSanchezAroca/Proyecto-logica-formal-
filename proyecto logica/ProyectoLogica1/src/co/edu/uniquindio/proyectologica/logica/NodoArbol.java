/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniquindio.proyectologica.logica;

import java.awt.Color;

/**
 *
 * @author juan david
 */

public class NodoArbol<T extends Comparable> implements Comparable<T> {

    /**
     * Nodo Hermano
     */
    private NodoArbol<T> hermano;
    /**
     * Nodo hijo
     */
    private NodoArbol<T> hijo;
    /**
     * Nodo padre
     */
    private NodoArbol<T> padre;
    /**
     * Coordenada en el eje x para el nodo
     */
    private int coordXNodo;
    /**
     * Coordenada en el eje y para el nodo
     */
    private int coordYNodo;
    /**
     * Coordenada de la raya inicial en el eje x
     */
    private int rayaXini;
    /**
     * Coordenada de la raya inicial en el eje y
     */
    private int rayaYini;
    /**
     * Coordenada de la raya final en el eje x
     */
    private int rayaXfin;
    /**
     * Coordenada de la raya final en el eje y
     */
    private int rayaYfin;
    /**
     * Dato de la clase nodo
     */
    private T dato;
    /**
     * Color para el nodo
     */
    private Color color;

    /**
     * Constructor de la clase Nodo
     *
     * @param dato informacion
     */
    public NodoArbol(T dato) {
        this.dato = dato;
        hijo = null;
        hermano = null;
        color = Color.BLACK;
    }//Cierre del constructor 

    /**
     * Constructor sobreCargado de la clase nodo
     *
     * @param dato // informacion
     * @param padre // nodo padre
     * @param coordXNodo// coordenada en el eje x del nodo
     * @param coordYNodo// Coordenada en el eje y del nodo
     * @param rayaXini// Coordenada inicial de la raya en el eje x
     * @param rayaYini// Coordenada inicial de la raya en el eje y
     * @param rayaXfin// Coordenada final de la raya en el eje x
     * @param rayaYfin // Coordenada final de la raya en el eje y
     */
    public NodoArbol(T dato, NodoArbol padre, int coordXNodo, int coordYNodo, int rayaXini, int rayaYini, int rayaXfin, int rayaYfin) {
        this.dato = dato;
        this.coordXNodo = coordXNodo;
        this.coordYNodo = coordYNodo;
        this.rayaXini = rayaXini;
        this.rayaYini = rayaYini;
        this.rayaYfin = rayaYfin;
        this.rayaXfin = rayaXfin;
        this.dato = dato;
        this.padre = padre;
        hijo = null;
        hermano = null;
        color = Color.BLACK;
    }// Cierre del constructor cargado 

    /**
     * Metodo para obtener el padre del nodo
     *
     * @return nodo padre
     */
    public NodoArbol<T> getPadre() {
        return padre;
    }

    /**
     * Metodo para modificar el nodo padre
     *
     * @param padre Nodo padre
     */
    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;
    }

    /**
     * Metodo que obtiene la coordenada en el eje x del nodo
     *
     * @return coordenada en el eje x del nodo
     */
    public int getCoordXNodo() {
        return coordXNodo;
    }

    /**
     * Metodo que modifica la coordenada en el eje x del nodo
     *
     * @param coordXNodo Coordenada nueva
     */
    public void setCoordXNodo(int coordXNodo) {
        this.coordXNodo = coordXNodo;
    }

    /**
     * Metodo que obtiene la coordenada en el eje y del nodo
     *
     * @return coordenada en el eje y del nodo
     */
    public int getCoordYNodo() {
        return coordYNodo;
    }

    /**
     * Metodo que modifica la coordenada en el eje y del nodo
     *
     * @param coordYNodo Coordenada nueva
     */
    public void setCoordYNodo(int coordYNodo) {
        this.coordYNodo = coordYNodo;
    }

    /**
     * Metodo que obtiene el hijo de un nodo
     *
     * @return nodo hijo
     */
    public NodoArbol<T> getHijo() {
        return hijo;
    }

    /**
     * Metodo que obtiene el hermano de un nodo
     *
     * @return Nodo hermano
     */
    public NodoArbol<T> getHermano() {
        return hermano;
    }

    /**
     * Metodo que modifica nodo hermano
     *
     * @param hermano Nodo hermano nuevo
     */
    public void setHermano(NodoArbol<T> hermano) {
        this.hermano = hermano;
    }

    /**
     * Metodo que obtiene el dato del nodo
     *
     * @return informacion
     */
    public T getDato() {
        return dato;
    }

    /**
     * Metodo que modifica el hijo de un nodo
     *
     * @param padre nodo padre
     */
    public void setHijo(NodoArbol<T> padre) {
        this.hijo = padre;
    }

    /**
     * Metodo que modifica el dato de un nodo
     *
     * @param dato informacion nueva
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Metodo que obtiene las coordenadas de la raya inicial en el eje x
     *
     * @return coordenadas en el eje x de la raya
     */
    public int getRayaXini() {
        return rayaXini;
    }

    /**
     * Metodo que modifica la coordenadas de la raya en el eje y inicial
     *
     * @param rayaXini coordenadas nuevas
     */
    public void setRayaXini(int rayaXini) {
        this.rayaXini = rayaXini;
    }

    /**
     * Metodo que obtiene las coordenadas de la raya inicial en el eje y
     *
     * @return coordenadas de la raya en el eje y inicial
     */
    public int getRayaYini() {
        return rayaYini;
    }

    /**
     * Metodo que modifica la raya inicial en el eje y
     *
     * @param rayaYini coordenadas nuevas
     */
    public void setRayaYini(int rayaYini) {
        this.rayaYini = rayaYini;
    }

    /**
     * Metodo que obtiene las coordenadas fin en el eje x de la raya
     *
     * @return coordenadas de la raya en el eje x fin
     */
    public int getRayaXfin() {
        return rayaXfin;
    }

    /**
     * Metodo que modifica la raya fin en el eje x
     *
     * @param rayaXfin coordenadas nuevas
     */
    public void setRayaXfin(int rayaXfin) {
        this.rayaXfin = rayaXfin;
    }

    /**
     * Metodo que obtiene las coordenadas de la raya fin en el eje y
     *
     * @return coordenadas de la raya en el eje y
     */
    public int getRayaYfin() {
        return rayaYfin;
    }

    /**
     * Metodo que modifica las coordenadas de la raya fin en el eje y
     *
     * @param rayaYfin coordenadas nuevas
     */
    public void setRayaYfin(int rayaYfin) {
        this.rayaYfin = rayaYfin;
    }

    /**
     * Metodo compareto sobreEscrito
     *
     * @param o Objeto
     * @return 0 si es igual, 1 si es mayor, -1 si es menor
     */
    @Override
    public int compareTo(T o) {
        return dato.compareTo(o);
    }

    /**
     * Metodo que obtiene el color del nodo
     *
     * @return color del nodo
     */
    public Color getColor() {
        return color;
    }

    /**
     * Metodo que modifica el color del nodo
     *
     * @param color color nuevo
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
