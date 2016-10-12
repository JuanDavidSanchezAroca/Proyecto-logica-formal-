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
public class IteratorLCD <T> implements Iterator<T>
{
      
   
    
    /*
     * Nodo cabecera de la Lista
     */
    private NodoD<T> cab;            
    
    /*
     * Nodo de la Lista a Iterar
     */
    private NodoD<T> posicion; 
    
    IteratorLCD(NodoD<T> cab) {

        this.cab=cab;                       
        this.posicion=this.cab.getSig();

    }
    @Override
    public boolean hasNext() {
     return (this.posicion!=this.cab);  
    }

    @Override
    public T next() {
       if(!this.hasNext())
            return (null);
        this.posicion=this.posicion.getSig();
        return(this.posicion.getAnt().getInfo());
    }
@Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
   
      
}
