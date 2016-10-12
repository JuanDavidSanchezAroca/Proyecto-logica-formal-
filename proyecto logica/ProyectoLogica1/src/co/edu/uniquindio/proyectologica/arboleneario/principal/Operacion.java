/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniquindio.proyectologica.arboleneario.principal;

import co.edu.uniquindio.proyectologica.logica.ArbolEneario;

/**
 *
 * @author juan david
 */
public class Operacion 
{
	/**
	 * Instanceamos el arbol Eneario para obtener 
	 * de el sus parametros y setearlo
	 */
   private  ArbolEneario arbol;

    public ArbolEneario getArbol() {
        return arbol;
    }

    public void setArbol(ArbolEneario arbol) {
        this.arbol = arbol;
    }
  
   public Operacion()
   {
     arbol=new ArbolEneario();
   }
   
}
