/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.proyectologica.logica;

import co.edu.uniquindio.proyectologica.excepciones.AlturaException;
import co.edu.uniquindio.proyectologica.excepciones.NoTienePadreException;
import co.edu.uniquindio.proyectologica.gui.ArbolExpresionGrafico;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author juan david
 * @param <T>
 */
public class ArbolEneario<T extends Comparable> {

    /**
     * Nodo raiz del Arbol Eneario
     */
    private NodoArbol<T> raiz;

    /**
     * Costructor cargado de la clase arboleneario
     *
     * @param datoInicial dato inicial
     */
    public ArbolEneario(T datoInicial) {
        raiz = new NodoArbol<>(datoInicial);
    }//Cierre del constructor cargado 

    /**
     * Constructor de la clase
     */
    public ArbolEneario() {
        raiz = null;
    }// Cierre del constructor 

    /**
     * Metodo que retorna el dato de la raiz del arbol
     *
     * @return dato o informacion
     */
    public T getDatoRaiz() {
        return raiz.getDato();
    }

    /**
     * Metodo que borra la informacion del arbol
     */
    public void vaciarArbol() {
        raiz = null;
    }

    /**
     * Metodo que calcula si el arbol esta vacio
     *
     * @return true si el arbol esta vacio, false si no;
     */
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * Metodo que calcula la altura de un nodo especifico
     *
     * @param padre nodo
     * @return entero con el numero que representa la altura del arbol
     */
    public int contarAltura(NodoArbol<T> padre) {
        int c = 0;
        NodoArbol<T> aux = padre;
        while (aux.getPadre() != null) {
            aux = aux.getPadre();
            c++;
        }

        return c;
    }

    /**
     * Metodo que inserta un hijo a un nodo
     *
     * @param padre // padre al cual se va agregar el nodo
     * @param dato // Dato o informacion del nodo
     * @param coordeXNodo// Coordenada en el eje x del nodo
     * @param coordeYNodo// Coordenada en el eje y del nodo
     * @param rayaXini// Coordenada de la raya inicial en el eje x
     * @param rayaYini// Coordenada de la raya inicial en el eje y
     * @param rayaXfin// Coordenada de la raya final en el eje x
     * @param rayaYfin// Coordenada de la raya final en el eje y
     * @return true si se agrego, false si no
     * @throws
     * co.edu.uniquindio.edu.arboleneario.gui.exception.NoTienePadreException
     */
    public boolean insertarHijo(NodoArbol padre, T dato, int coordeXNodo, int coordeYNodo, int rayaXini, int rayaYini, int rayaXfin, int rayaYfin) throws NoTienePadreException, AlturaException {
        NodoArbol<T> nuevo = new NodoArbol(dato, padre, coordeXNodo, coordeYNodo, rayaXini, rayaYini, rayaXfin, rayaYfin);

        // el arbol esta vacio 
        if (this.esVacio()) {
            this.setRaiz(nuevo, 0, 0);
            return true;
        }
        // padre del nodo 
        NodoArbol pa = padre;

        // si el dato ya existe o no tiene padre 
        if (pa == null) {
            throw new NoTienePadreException();
        }
        // si el padre es hoja y no tiene hijos 
        if (esHoja(pa)) {
            pa.setHijo(nuevo);
            return true;
        }
        NodoArbol<T> q = pa.getHijo();
        pa.setHijo(nuevo);
        nuevo.setHermano(q);
        return true;

    }

    /**
     * Metodo que hace el recorrido por anchura del arbol
     *
     * @return iterador para recorrer por anchura
     */
    public Iterator<T> recorridoAnchura() {
        Cola<NodoArbol<T>> c = new Cola();
        ListaCD<T> l = new ListaCD();
        if (this.esVacio()) {
            return (l.iterator());
        }
        NodoArbol<T> s, q;
        c.enColar(this.raiz);
        while (!c.esVacia()) {
            q = c.deColar();
            if (q != null) {
                l.insertarAlFinal(q.getDato());
                s = q.getHijo();
                while (s != null) {
                    c.enColar(s);
                    s = s.getHermano();
                }
            }
        }
        return (l.iterator());
    }

    /**
     * Metodo que recorre el arbol en preOrden
     *
     * @return iterador PreOrden
     */
    public Iterator<T> preOrden() {
        ListaCD<T> l = new ListaCD<T>();
        preOrden(this.getRaiz(), l);
        return (l.iterator());
    }

    /**
     * Metodo recorrer preOrden
     *
     * @param r Raiz del arbol
     * @param l lista circular
     */
    public void preOrden(NodoArbol<T> r, ListaCD<T> l) {
        NodoArbol<T> q;
        // raiz diferente de null
        if (r != null) {

            l.insertarAlFinal(r.getDato());
            q = r.getHijo();
            // si raiz tiene hijo 
            if (q != null) {
                //recursiviadad para recorrer 
                preOrden(q, l);
                q = q.getHermano();

                while (q != null) {
                    preOrden(q, l);
                    q = q.getHermano();
                }
            }
        }
    }

    /**
     * Metodo publico que recorre el arbol en in orden
     *
     * @return iterador para recorrer
     */
    public Iterator<T> inOrden() {
        ListaCD<T> l = new ListaCD<T>();
        inOrden(this.getRaiz(), l);
        return (l.iterator());
    }

    /**
     * Metodo que recorre el arbol en post orden
     *
     * @return itarador para recorrer
     */
    public Iterator<T> postOrden() {
        ListaCD<T> l = new ListaCD<T>();
        postOrden(this.getRaiz(), l);
        return (l.iterator());
    }

    /**
     * Metodo de tipo privado que retorna un iterador con el recorrido postOrden
     * del Arbol Eneario. Se retorno un iterador postOrden para el arbol.
     *
     * @param r representa la raiz del arbol, o raiz de subarbol.
     * @param l Lista para el almacenamiento de los datos del arbol.
     */
    private void postOrden(NodoArbol<T> r, ListaCD<T> l) {
        NodoArbol<T> q;
        if (r != null) {
            q = r.getHijo();
            while (q != null) {
                postOrden(q, l);
                q = q.getHermano();
            }
            l.insertarAlFinal(r.getDato());
        }
    }

    /**
     * Metodo de tipo privado que retorna un Iterador con el recorrido in Orden
     * del Arbol Eneario. Se retorno un iterador inOrdenpara el Arbol.
     *
     * @param r representa la raiz del Arbol, o raiz de subarbol.
     * @param l Lista para el almacenamiento de los datos del Arbol.
     */
    private void inOrden(NodoArbol<T> r, ListaCD<T> l) {
        NodoArbol<T> q;
        if (r != null) {
            q = r.getHijo();
            if (q == null) {
                l.insertarAlFinal(r.getDato());
            } else {
                inOrden(q, l);
                l.insertarAlFinal(r.getDato());
                q = q.getHermano();
                while (q != null) {
                    inOrden(q, l);
                    q = q.getHermano();
                }
            }
        }
    }

    public int getGordura() {
        return (gordura());
    }

    /**
     * Metodo que calcula la gordura del arbol
     *
     * @return entero con la cantidad de gordura
     */
    public int gordura() {
        if (this.esVacio()) {
            return (0);
        }
        int masGordo = -1;
        Cola<NodoArbol<T>> cola = new Cola<NodoArbol<T>>();
        Cola<Integer> c = new Cola<Integer>();
        NodoArbol<T> s, q;
        int i = 0;
        int cont = 1, ant = -1;
        cola.enColar(this.getRaiz());
        c.enColar(i);
        while (!cola.esVacia()) {
            q = cola.deColar();
            i = c.deColar();
            if (i != ant) {
                if (masGordo < cont) {
                    masGordo = cont;
                }
                cont = 0;
                ant = i;
            }
            cont++;
            s = q.getHijo();
            while (s != null) {
                cola.enColar(s);
                c.enColar(i + 1);
                s = s.getHermano();
            }
        }
        return ((masGordo < cont) ? cont : masGordo);
    }

    /**
     * Metodo para insertar hermano a un nodo
     *
     * @param padre padre del nodo
     * @param hermano hermano del nodo
     * @param dato informacion
     * @param coordeXNodo coordenada en el eje x del nodo
     * @param coordeYNodo coodenada en el eje y del nodo
     * @param rayaXini coordenada
     * @param rayaYini
     * @param rayaXfin
     * @param rayaYFin
     * @return
     */
    public boolean insertarHermano(NodoArbol padre, T hermano, T dato, int coordeXNodo, int coordeYNodo, int rayaXini, int rayaYini, int rayaXfin, int rayaYFin) {
        NodoArbol<T> nuevo = new NodoArbol(dato, padre, coordeXNodo, coordeYNodo, rayaXini, rayaYini, rayaXfin, rayaYFin);
        nuevo.setPadre(padre);
        //El arbol se encuentra vacio      
        if (esVacio()) {
            this.raiz = nuevo;
            return (true);
        }
        NodoArbol h = this.buscar(hermano, (T) padre.getDato());

        //Si es la raiz
        if (this.raiz == h || h == null) {
            return (false); //Hermano de la raiz, hermano Null o ya existe
        }
        NodoArbol<T> sigH = h.getHermano();
        h.setHermano(nuevo);
        nuevo.setHermano(sigH);
        return (true);
    }

    public boolean esHoja(NodoArbol<T> r) {
        return (r.getHijo() == null);
    }

    private NodoArbol<T> getHermano(T info) {
        return (gHermano(this.raiz, null, info));
    }

    private NodoArbol<T> gHermano(NodoArbol<T> r, NodoArbol<T> h, T dato) {
        NodoArbol<T> p = null, q, s;
        if (r == null) {
            return (null);
        }
        if (r.getDato().equals(dato)) {
            return (h);
        }
        q = r.getHijo();
        while (q != null) {
            s = gHermano(q, p, dato);
            if (s != null) {
                return (s);
            }
            p = q;
            q = q.getHermano();
        }
        return (null);
    }

    public NodoArbol<T> buscar(T dato, T padre) {
        if (esVacio()) {
            return null;
        } else {
            return (this.buscar(this.raiz, dato, padre));
        }
    }

    /**
     * Metodo que nos permite buscar un nodo en especifico con respecto al dato
     *
     * @param ndoR buscamo el nodo raiz para comprobar de que el arbol no se
     * encuentre vacio y setiar sus hijos
     * @param dato por medio del dato podemos retornar el nodo deseado
     * @return retornamos el nodo que estamos buscando
     */
    private NodoArbol<T> buscar(NodoArbol<T> ndoR, T dato, T padre) {
        NodoArbol<T> q, s;
        if (ndoR == null) {
            return (ndoR);
        }
        if (padre != null) {
            if (ndoR.compareTo(dato) == 0 && ndoR.getPadre().getDato().equals(padre)) {
                if (ndoR.getHermano() == null) {
                    return (ndoR);
                } else {
                    if (ndoR.getHijo() == null) {
                        if(String.valueOf(ndoR.getDato()).length()!=1)
                        return (ndoR);
                    }
                }

            }
        } else if (ndoR.compareTo(dato) == 0) {
            if (ndoR.getHijo() == null) {
                return (ndoR);
            } else if (ndoR.getHijo().getHermano() == null&&ndoR.getHermano()==null) {
                return (ndoR);
            }
        }
        q = ndoR.getHijo();
        while (q
                != null) {
            s = buscar(q, dato, padre);
            if (s != null) {
                return (s);
            }
            q = q.getHermano();
        }

        return (null);
    }

    /**
     * Metodo para comprobar si el dato que estamos buscando se encuentra en el
     * arbol
     *
     * @param dato parametro con el que buscamos el nodo
     * @return
     */
    public boolean esta(T dato) {
        if (this.esVacio()) {
            return (false);
        }
        boolean rta = (this.esta(this.raiz, dato));
        return rta;
    }

    /**
     * Metodo que permite evaluar la existencia un dato dentro del Arbol
     * Eneario. Se evaluo la existencia de un dato dentro del Arbol.
     *
     * @param r Representa la raiz del Arbol Eneario en el que se buscara el
     * dato.
     * @param dato Representa el dato que se quiere localizar dentro del Arbol
     * Eneario.
     * @return Un objeto de tipo boolean que contiene un true si ubico el dato y
     * false en caso contrario.
     */
    private boolean esta(NodoArbol<T> r, T dato) {
        NodoArbol<T> q;
        boolean s;
        if (r == null) {
            return (false);
        }
        if (r.getDato().equals(dato)) {
            return (true);
        }
        q = r.getHijo();
        while (q != null) {
            s = esta(q, dato);
            if (s) {
                return (true);
            }
            q = q.getHermano();
        }
        return (false);

    }

    public boolean eliminar(T dato) {
        if (!this.esta(dato)) {
            return (false);
        }
        return (elimina(dato));
    }

    /**
     * Este metodo nos permite recorrer el arbol para obtener el numero de hijo
     * que tiene un padre
     *
     * @param padre buscamos si un nodo es padre y obtenemo la cantidad de hijo
     * que tiene
     * @return
     */
//    public Iterator<T> getHijos(T padre) {
//        ListaCD<T> l = new ListaCD<T>();
//        NodoArbol p = this.buscar(this.raiz, padre);
//        NodoArbol m = this.buscar(this.raiz, padre);
//        if (p == null) {
//            return (l.iterator()); //Este Nodo no existe
//        }
//        NodoArbol q = p.getHijo();
//        while (q != null) {
//            l.insertarAlFinal((T) q.getDato());
//            q = q.getHermano();
//        }
//        return (l.iterator());
//    }
    /**
     * Este es el metodo principal de elimar nodo con el cual se modificaran las
     * cordenadas correspondientes a cada nodo y teniendo en cuanta si tiene o
     * no hermano, si es padre para poder reacomodarlo
     *
     * @param dato parametro con el qu ebuscamos el nodo a eliminar
     * @return retornamos un boleano indicando que el nodo se elimino
     * correctamente
     */
    private boolean elimina(T dato) {
        NodoArbol<T> n, h, p, s, m, pad;
        n = this.getPadre(dato);

        //Es un hijo (Primer hijo a la izquierda)
        if (n != null) {
            h = n.getHijo();
            //Si tiene hijos, subo al primer hijo
            if (h.getHijo() != null) {
                s = h.getHijo();
                s.setRayaXini(n.getCoordXNodo());
                s.setRayaYini(n.getCoordYNodo());
                s.setPadre(n);
                n.setHijo(s);

                p = s;
                while (s != null) {
                    p = s;
                    s = s.getHermano();

                    if (s != null) {
                        s.setRayaXini(n.getCoordXNodo());
                        s.setRayaYini(n.getCoordYNodo());
                        s.setPadre(n);
                    }
                }
//                p.setRayaXini(p.getCoordXNodo());
//                p.setRayaYini(p.getCoordYNodo());
                p.setHermano(h.getHermano());
            } else {
                if (h.getHermano() != null) {
                    h.getHermano().setRayaXini(n.getCoordXNodo());
                    h.getHermano().setRayaYini(n.getCoordYNodo());
                }
                n.setHijo(h.getHermano());
            }
            return (true);
        }
        //Si es un hermano (Es un hijo pero no el primero)
        n = this.getHermano(dato);
        if (n != null) {
            h = n.getHermano();
            //Si tiene hijos, subo al primer hijo
            if (h.getHijo() != null) {
                s = h.getHijo();
                // h = h.getHermano();

                s.setRayaXini(h.getPadre().getCoordXNodo());
                s.setRayaYini(h.getPadre().getCoordYNodo());
                s.setPadre(h.getPadre());
                n.setHermano(s);
                p = s;

                while (s != null) {
                    p = s;
                    s = s.getHermano();
                    if (s != null) {
                        s.setRayaXini(h.getPadre().getCoordXNodo());
                        s.setRayaYini(h.getPadre().getCoordYNodo());
                    }
                }

                p.setHermano(h.getHermano());
            } else {
                n.setHermano(n.getHermano().getHermano());
            }
            return (true);
        }
        //Si es la raiz del Arbol
        return (eliminaR(dato));
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Este Metodo se encarga de eliminar la raiz de un arbol
     *
     * @param dato parametro con el que buscamos el nodo a eliminar
     * @return retornamo un booleano indicando que se elimino o no
     */
    private boolean eliminaR(T dato) {
        int c = 0;
        if (this.raiz.getDato() != dato) {
            return (false);
        }
        NodoArbol<T> h, p, s;
        setRaiz(this.raiz.getHijo());
        if (raiz != null) {
            raiz.setRayaXini(-1);
            raiz.setRayaYini(-1);
        }
        //Si tenia hijos
        if (this.raiz != null) {
            h = this.raiz.getHijo();
            s = this.raiz.getHermano();
            //Si no tiene hijos
            if (h == null) {
                while (s != null) {

                    s.setRayaXini(raiz.getCoordXNodo());
                    s.setRayaYini(raiz.getCoordYNodo());
                    if (c == 0) {
                        this.raiz.setHijo(s);
                    }
                    c++;
                    s = s.getHermano();
                }
            } else {
                p = h;
                while (h != null) {
                    p = h;
                    h = h.getHermano();
                }
                s.setRayaXini(raiz.getCoordXNodo());
                s.setRayaYini(raiz.getCoordYNodo());
                p.setHermano(s);
            }
        }
        return (true);
    }

    /**
     * Obtenemos el nodo correspondiente al padre de cada nodo
     *
     * @param info parametro con el cual se buca el padre
     * @return
     */
    public NodoArbol<T> getPadre(T info) {
        return (gPadre(this.raiz, null, info));
    }

    /**
     * Este metodo se encarga de obtener el nodo padre que posea cada nodo
     *
     * @param r parametro que es el nodo raiz
     * @param t parametro padre
     * @param dato este es el dato con el que se busca el padre
     * @return
     */
    private NodoArbol<T> gPadre(NodoArbol<T> r, NodoArbol<T> t, T dato) {
        NodoArbol<T> q, s;
        if (r == null) {
            return (null);
        }
        if (r.getDato().equals(dato)) {
            return (t);
        }
        q = r.getHijo();
        while (q != null) {
            s = gPadre(q, r, dato);
            if (s != null) {
                return (s);
            }
            r = null;
            q = q.getHermano();
        }
        return (null);
    }

    /**
     * Este metodo se encarga de modificar la raiz del arbol con respecto a sus
     * coordenadas
     *
     * @param raiz seteamos el nodo raiz
     * @param coordeXNodo cambiamos su coordenada en x
     * @param coordYnodo cambianos la coordenada en y
     */
    public void setRaiz(NodoArbol<T> raiz, int coordeXNodo, int coordYnodo) {
        raiz.setRayaXfin(-1);
        raiz.setRayaYfin(-1);
        raiz.setRayaXini(-1);
        raiz.setRayaYini(-1);
        this.raiz = raiz;
        this.raiz.setCoordXNodo(coordeXNodo);
        this.raiz.setCoordYNodo(coordYnodo);

    }

    /**
     * Este metodo se encar de obtener la raiz del arbol
     *
     * @return retorna el nodo raiz
     */
    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    /**
     * Este metodo verifica primeramente que el arbol no este vacio para poder
     * proceder con obtener la altura
     *
     * @return obtenemos la cantida de arcos que es equivalente a tener n-1
     * nodos
     */
    public int getAltura() {
        if (this.esVacio()) {
            return (0);
        }
        return (getAltura(this.getRaiz()) - 1);
    }

    /**
     * Este metodo se encarga de obtener la altura de del arbol, este indica el
     * camino mas largo desde la raiz hasta el nodo
     *
     * @param r paramtro raiz
     * @return el nuemro de arcos vistados desde la raiz hasta el ultimo nodo
     */
    public int getAltura(NodoArbol<T> r) {
        if (this.esHoja(r)) {
            return (1);
        }
        int maxAltura = 0;
        NodoArbol<T> q;
        if (r != null) {
            q = r.getHijo();
            if (q != null) {
                while (q != null) {
                    int auxAltura = getAltura(q);
                    if (auxAltura > maxAltura) {
                        maxAltura = auxAltura;
                    }
                    q = q.getHermano();
                }
            }
        }
        return (maxAltura + 1);
    }

    /**
     * Metodo que permite obtener el peso del Arbol Eneario. <br>
     * <b>post: </b> Se retorno el numero de elementos en el Arbol Eneario.<br>
     *
     * @return Un entero con la cantidad de elementos del Arbol Eneario.
     */
    public int getPeso() {
        return (getPeso(this.getRaiz()));
    }

    /**
     * Metodo de tipo privado que permite conocer el numero de elemento del
     * Arbol Eneario. <br>
     * <b>post: </b> Se retorno el numero de elementos en el Arbol.<br>
     *
     * @param r Representa la raiz del Arbol, o raiz de subarbol. <br>
     * @return El munero de elementos que contiene el Arbol Eneario.
     */
    private int getPeso(NodoArbol<T> r) {
        NodoArbol<T> q;
        int cant = 0;
        if (r != null) {
            cant++;
            q = r.getHijo();
            if (q != null) {
                cant += getPeso(q);
                q = q.getHermano();
                while (q != null) {
                    cant += getPeso(q);
                    q = q.getHermano();
                }
            }
        }
        return (cant);
    }

    public JPanel getDibujo() {
        return new ArbolExpresionGrafico(this);
    }

}
