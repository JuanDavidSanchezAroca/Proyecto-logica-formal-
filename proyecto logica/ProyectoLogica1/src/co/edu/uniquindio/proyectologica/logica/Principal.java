package co.edu.uniquindio.proyectologica.logica;

import co.edu.uniquindio.proyectologica.arboleneario.principal.Operacion;
import co.edu.uniquindio.proyectologica.excepciones.AlturaException;
import co.edu.uniquindio.proyectologica.excepciones.NoTienePadreException;
import co.edu.uniquindio.proyectologica.excepciones.ValidacionExcepcion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * Clase principal que contiene la logica
 *
 * @author juan David Sanchez Aroca
 * @author carlos alberto cardona beltran
 * @author camilo correa pacheco
 * @version 1.0
 */
public class Principal {

    /**
     * Arreglo que va almacenar la funcion en subformulas
     */
    private ArrayList<String> funcionPartes;
    /**
     * Arreglo que contiene las palabras proposiciones de la formula
     */
    private ArrayList<Character> c;
    /**
     * Arreglo que contiene las soluciones de una formula proposicional
     */
    private ArrayList<Integer> x;
    /**
     * Mapa que almacena la llave (forma proposicional) y la solucion
     */
    private HashMap<String, ArrayList<Integer>> mapa;
    /**
     * Atributo que instancia el arbol
     */
    private Operacion operacion;

    private int cantidadNodos;

    private ArrayList<String> conjuntoSub;

    /**
     * Constructor de la clase principal
     */
    public Principal() {
        super();
        this.operacion = new Operacion();
        this.conjuntoSub = new ArrayList<>();
    }

    /**
     * Metodo que valida que la formula este bien formada
     *
     * @param funcion cadena que contiene la funcion
     * @throws ValidacionExcepcion excepcion lanzada
     */
    public void validarFuncion(String funcion) throws ValidacionExcepcion {

        if (funcion.equals("")) {
            throw new ValidacionExcepcion();
        } else {
            for (int i = 0; i < funcion.length(); i++) {
                if (funcion.charAt(i) == '(' && funcion.charAt(i + 2) == ')' && funcion.charAt(i + 1) == ' ') {
                    throw new ValidacionExcepcion();
                }
            }
        }

    }

    /**
     * Metodo que cuenta y agrega las proposiciones de una funcion
     *
     * @param funcion funcion proposicional
     */
    public void contarProposiciones(String funcion) {
        c = new ArrayList<>();
        if (funcion != null) {
            for (int i = 0; i < funcion.length(); i++) {// recorriendo la funcion.....
                if (funcion.charAt(i) == '(' && funcion.charAt(i + 1) != ' ' && funcion.charAt(i + 2) == ')') {
                    if (!c.contains(funcion.charAt(i + 1))) {
                        c.add(funcion.charAt(i + 1));
                    }
                }
            }
        }
        llenarValoresProposiciones();
        partirFuncion(funcion, null, null);
    }

    /**
     * Metodo que llena un vector con los valores de la proposicion
     */
    public void llenarValoresProposiciones() {
        mapa = new HashMap<>();
        int potencia = (int) Math.pow(2, c.size()) / 2;
        int potencia1 = (int) Math.pow(2, c.size()) / 2;

        for (Character c1 : c) {
            ArrayList<Integer> aux = new ArrayList<>();
            for (int j = 1; j <= Math.pow(2, c.size()); j++) {
                if (potencia != 0 && potencia <= potencia1) {
                    aux.add(1);
                    potencia--;
                } else if (potencia == 0) {
                    potencia = potencia1 * 2;
                    aux.add(0);
                    potencia--;
                } else {
                    aux.add(0);
                    potencia--;
                }
            }
            potencia1 = potencia1 / 2;
            potencia = potencia1;
            mapa.put(c1.toString(), aux);
        }

    }

    /**
     * Metodo que devuelve el valor contrario de la proposicion
     *
     * @param v arreglo de proposiciones
     * @return arreglo con valores contrarios
     */
    public ArrayList negacion(ArrayList<Integer> v) {
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) == 1) {
                vector.add(0);
            } else if (v.get(i) == 0) {
                vector.add(1);
            }
        }
        return vector;
    }

    /**
     * Metodo que devuelve la conjuncion de dos arreglos de proposiciones
     *
     * @param v1 arreglo de proposicion
     * @param v2 arreglo de proposicion
     * @return arreglo con la conjucion entre los dos arreglos
     */
    public ArrayList conjuncion(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) == 1 && v2.get(i) == 1) {
                vector.add(1);
            } else {
                vector.add(0);
            }
        }
        return vector;
    }

    /**
     * Metodo que devuelve la disyuncion entre dos arreglos de proposiciones
     *
     * @param v1 arreglo de proposicion
     * @param v2 arreglo de proposicion
     * @return arreglo con la disyuncion entre dos arreglos
     */
    public ArrayList disyuncion(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) == 1 || v2.get(i) == 1) {
                vector.add(1);
            } else {
                vector.add(0);
            }
        }
        return vector;
    }

    /**
     * Metodo que devuelve la forma condicional entre dos arreglos de
     * proposiciones
     *
     * @param v1 arreglo de proposicion
     * @param v2 arreglo de proposicion
     * @return arreglo condicional entre dos arreglos
     */
    public ArrayList condicional(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) == 1 && v2.get(i) == 1) {
                vector.add(1);
            } else if (v1.get(i) == 1 && v2.get(i) == 0) {
                vector.add(0);
            } else if (v1.get(i) == 0 && v2.get(i) == 1) {
                vector.add(1);
            } else if (v1.get(i) == 0 && v2.get(i) == 0) {
                vector.add(1);
            }
        }
        return vector;
    }

    /**
     * Metodo que devuelve la forma bicondicional entre dos arreglos de
     * proposiciones
     *
     * @param v1 arreglo de proposicion
     * @param v2 arreglo de proposicion
     * @return arreglo bicondicional entre dos arreglos
     */
    public ArrayList bicondicional(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) == 1 && v2.get(i) == 1 || v1.get(i) == 0 && v2.get(i) == 0) {
                vector.add(1);
            } else {
                vector.add(0);
            }
        }
        return vector;
    }

    /**
     * Metodo que cuenta la cantidad de parentesis de una funcion proposicional
     *
     * @param funcion funcion proposicional
     * @return numero de parentesis de una funcion
     */
    public int contarParentesis(String funcion) {
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < funcion.length(); i++) {
            if (funcion.charAt(i) == '(') {
                pila.add('(');
            } else if (funcion.charAt(i) == ')') {
                pila.pop();
            } else if (pila.empty() && i != 0) {
                return i;
            }
        }
        if (pila.empty()) {
            return funcion.length();
        }
        return -1;
    }

    /**
     * Metdo que divide una formula proposicional en su minima expresion y la
     * resuelve
     *
     * @param funcion formula proposicional
     * @return arreglo con la solucion de una formula proposicional
     */
    public ArrayList partirFuncion(String funcion, String padre, String hermano) {
        if (funcion.charAt(0) >= 'p' && funcion.charAt(0) <= 'z') { // caso base
            agregarNodo(funcion, padre, hermano);
            if (!conjuntoSub.contains(funcion)) {
                conjuntoSub.add(funcion);
            }
            return mapa.get(String.valueOf(funcion.charAt(0)));
        } else if (contarParentesis(funcion) == funcion.length() && funcion.charAt(0) != '¬') {// si empieza con parentesis
            return partirFuncion(funcion.substring(1, funcion.length() - 1), padre, hermano);
        } else if (contarParentesis(funcion) == funcion.length() && funcion.charAt(0) == '¬') {// si empieza con negacion 
            x = new ArrayList<>();
            agregarNodo(funcion, padre, hermano);
            if (!conjuntoSub.contains(funcion)) {
                conjuntoSub.add(funcion);
            }
            x = negacion(partirFuncion(funcion.substring(2, funcion.length() - 1), funcion, null));
            mapa.put(funcion, x);
            return x;
        } else {
            int j = contarParentesis(funcion);
            if (funcion.charAt(j) == '˄') {// conjuncion 
                x = new ArrayList<>();
                agregarNodo(funcion, padre, hermano);
                if (!conjuntoSub.contains(funcion)) {
                    conjuntoSub.add(funcion);
                }
                x = conjuncion(partirFuncion(funcion.substring(0, j), funcion, null), partirFuncion(funcion.substring(j + 1, funcion.length()), funcion, funcion.substring(1, j - 1)));
                mapa.put(funcion, x);
                return x;
            } else if (funcion.charAt(j) == '˅') {//disyuncion 
                x = new ArrayList<>();
                agregarNodo(funcion, padre, hermano);
                if (!conjuntoSub.contains(funcion)) {
                    conjuntoSub.add(funcion);
                }
                x = disyuncion(partirFuncion(funcion.substring(0, j), funcion, null), partirFuncion(funcion.substring(j + 1, funcion.length()), funcion, funcion.substring(1, j - 1)));
                mapa.put(funcion, x);
                return x;
            } else if (funcion.charAt(j) == '→') { //condicional
                x = new ArrayList<>();
                agregarNodo(funcion, padre, hermano);
                if (!conjuntoSub.contains(funcion)) {
                    conjuntoSub.add(funcion);
                }
                x = condicional(partirFuncion(funcion.substring(0, j), funcion, null), partirFuncion(funcion.substring(j + 1, funcion.length()), funcion, funcion.substring(1, j - 1)));
                mapa.put(funcion, x);
                return x;
            } else if (funcion.charAt(j) == '↔') {// bi-condicional
                x = new ArrayList<>();
                agregarNodo(funcion, padre, hermano);
                if (!conjuntoSub.contains(funcion)) {
                    conjuntoSub.add(funcion);
                }
                x = bicondicional(partirFuncion(funcion.substring(0, j), funcion, null), partirFuncion(funcion.substring(j + 1, funcion.length()), funcion, funcion.substring(1, j - 1)));
                mapa.put(funcion, x);
                return x;
            }

        }

        return null;
    }

    /**
     * Metodo que obtiene los valores del mapa
     *
     * @return mapa
     */
    public HashMap<String, ArrayList<Integer>> getMapa() {
        return mapa;
    }

    /**
     * Metodo que obtiene un arreglo con las palabras proposicionales
     *
     * @return
     */
    public ArrayList<Character> getC() {
        return c;
    }

    /**
     * Metodo que ordena el mapa con sus formulas proposicioanles
     *
     * @param m mapa que se ordenara
     * @return mapa ordenado
     */
    public Map<String, ArrayList<Integer>> ordenarMapa(HashMap<String, ArrayList<Integer>> m) {
        Map<String, ArrayList<Integer>> nuevo = new LinkedHashMap<>();
        String nombres[] = new String[mapa.size()];
        int cont = 0;
        for (Map.Entry<String, ArrayList<Integer>> s : mapa.entrySet()) {
            nombres[cont] = s.getKey();
            cont++;
        }
        int i, j;
        String aux;
        for (i = 0; i < nombres.length - 1; i++) {
            for (j = 0; j < nombres.length - 1; j++) {
                if (nombres[j].length() > nombres[j + 1].length()) {
                    aux = nombres[j + 1];
                    nombres[j + 1] = nombres[j];
                    nombres[j] = aux;
                }
            }
        }
        for (String nombre : nombres) {
            for (int k = 0; k < c.size(); k++) {
                nuevo.put(String.valueOf(c.get(k)), m.get(String.valueOf(c.get(k))));

            }
            if (nombre.length() != 1) {
                nuevo.put(nombre, m.get(nombre));
            }
        }
        return nuevo;
    }

    /**
     * Metodo que me permite abrir el documento desde un jar
     *
     * @throws IOException se delegan las excepciones correspondientes
     */
    public void abrirDocumento() throws IOException {
        File directorio = new File("temp"); //Creas un nuevo directorio a nivel de tu jar.
        directorio.mkdirs();
        directorio.setWritable(true);
        //nuevo archivo en esa direccion
        File temp = new File("temp/manual.pdf");
        InputStream is = this.getClass().getResourceAsStream("/archivo/manual.pdf");
        FileOutputStream archivoDestino = new FileOutputStream(temp);
        FileWriter fw = new FileWriter(temp);
        byte[] buffer = new byte[512 * 1024];
        //lees el archivo hasta que se acabe...
        int nbLectura;
        while ((nbLectura = is.read(buffer)) != -1) {
            archivoDestino.write(buffer, 0, nbLectura);
        }
        //cierras el archivo,el inputS y el FileW
        fw.close();
        archivoDestino.close();
        is.close();
        //abres el archivo temporal
        Desktop.getDesktop().open(temp);
    }

    public void agregarNodo(String funcion, String padre, String hermano) {
        // Si no hay nodos 
        if (cantidadNodos == 0) {
            operacion.getArbol().setRaiz(new NodoArbol(funcion), 50, 10);
            cantidadNodos++;
        } else {
            // si es el primer hijo del padre 
            if (operacion.getArbol().buscar(padre, null) != null) {

                if (operacion.getArbol().esHoja(operacion.getArbol().buscar(padre, null))) {
                    try {
                        operacion.getArbol().insertarHijo(operacion.getArbol().buscar(padre, null), funcion, 100, 50, operacion.getArbol().buscar(padre, null).getCoordXNodo(),
                                operacion.getArbol().buscar(padre, null).getCoordYNodo(), 50, 20);
                    } catch (NoTienePadreException | AlturaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    cantidadNodos++;
                    // si el padre ya tiene hijos 
                } else {
                    if (operacion.getArbol().buscar(hermano, padre) != null) {
                        System.out.println(operacion.getArbol().buscar(hermano, padre).getDato());
                        if (operacion.getArbol().buscar(hermano, padre).getPadre() != null) {
                            operacion.getArbol().insertarHermano(operacion.getArbol().buscar(padre, null), hermano, funcion, 20, 30, operacion.getArbol().buscar(padre, null).getCoordXNodo(), operacion.getArbol().buscar(padre, null).getCoordYNodo(), 50, 60);
                            cantidadNodos++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Este nodo hermano no es hermano");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Este nodo no hace parte del grafo");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Este nodo padre no esta o el arbol no puede sobrepasar los 6 niveles");
            }
        }
    }

    public ArrayList<String> getConjuntoSub() {
        return conjuntoSub;
    }
    
    

    public Operacion getOperacion() {
        return operacion;
    }

}
