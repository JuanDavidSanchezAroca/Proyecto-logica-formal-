/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.proyectologica.gui;

import co.edu.uniquindio.proyectologica.logica.ArbolEneario;
import co.edu.uniquindio.proyectologica.logica.NodoArbol;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author juan david
 */
public class ArbolExpresionGrafico<T> extends JPanel {

    private ArbolEneario miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 15, child2child = 40;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;
    private JFrame ventana;
    private JPanel panel;
    private JScrollPane scroll;

    /**
     * Constructor de la clase ArbolExpresionGrafico. El constructor permite
     * inicializar los atributos de la clase ArbolExpresionGrafico y llama al
     * método repaint(), que es el encargado de pintar el Arbol.
     *
     * @param miExpresion: dato de tipo ArbolExpresion que contiene el Arbol a
     * dibujar.
     */
    public ArbolExpresionGrafico(ArbolEneario miArbol) {
        this.miArbol = miArbol;
        componentes();
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap();
        subtreeSizes = new HashMap();
        dirty = true;
        repaint();
    }

    public void componentes() {
        ventana = new JFrame();
        ventana.setTitle("Graficador de Arboles");
        ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.setSize(1500, 700);
        this.setSize(2000, 2000);
        this.scroll = new JScrollPane(this);
        this.scroll.setSize((int) this.getSize().getWidth(), (int) this.getSize().getHeight());
        this.scroll.setBounds(50, 50, 1500, 600);
        ventana.getContentPane().add(scroll);
        ventana.setVisible(true);
    }

    /**
     * Calcula las posiciones de los respectivos subárboles y de cada nodo que
     * forma parte de ese subárbol, para conocer en que posición van a ir
     * dibujados los rectángulos representativos del árbol de la expresión.
     */
    private void calcularPosiciones() {
        posicionNodos.clear();
        subtreeSizes.clear();
        NodoArbol root = this.miArbol.getRaiz();
        if (root != null) {
            calcularTamañoSubarbol(root);

            calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, false, 0);
        }
    }

    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de
     * la clase de tipo HashMap que va a contener la coleccion de todos los
     * subárboles que contiene un arbol.
     *
     * @param n:Objeto de la clase NodoB <T> que se utiliza como referencia
     * calcular el tamaño de cada subárbol.
     * @return Dimension con el tamaño de cada subárbol.
     */
    private Dimension calcularTamañoSubarbol(NodoArbol n) {
        Dimension rd;
        if (n == null) {
            return new Dimension(0, 0);
        }

        Dimension ld = calcularTamañoSubarbol(n.getHijo());
        if (n.getHijo() != null) {
            rd = calcularTamañoSubarbol(n.getHijo().getHermano());
        } else {
            rd = new Dimension(0, 0);
        }

        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;

        Dimension d;
        if (n.getHijo()!= null && n.getHijo().getHijo() != null && n.getHijo().getHermano() == null) {
            ld.setSize(ld.getWidth() + 3, h);
            d = ld;

        } else {
            d = new Dimension(w, h);

        }
        subtreeSizes.put(n, d);

        return d;
    }

    /**
     * Calcula la ubicación de cada nodo de cada subárbol y agrega cada nodo con
     * un objeto de tipo Rectangule que tiene la ubicación y la información
     * específica de dónde va a ser dibujado.
     *
     * @param n: Objeto de tipo NodoB <T> que se utiliza como referencia para
     * calcular la ubicación de cada nodo.
     * @param left: int con alineación y orientación a la izquierda.
     * @param right: int con alineación y orientación a la derecha.
     * @param top: int con el tope.
     */
    private void calcularPosicion(NodoArbol n, int left, int right, int top, boolean continuar, int contar) {
        Dimension rd;
        if (n == null) {
            return;
        }
        Dimension ld = null;
       // ld = (Dimension) subtreeSizes.get(n.getHijo());

        if (ld == null) {
            ld = empty;
        }

        if (n.getHijo() != null && !continuar) {
            rd = (Dimension) subtreeSizes.get(n.getHijo().getHermano());
        } else {
            rd = null;
        }
        if (rd == null) {
            rd = empty;
        }

        int center = 0;

        if (right != Integer.MAX_VALUE) {
            center = right - rd.width - child2child / 2;
        } else if (left != Integer.MAX_VALUE) {
            center = left + ld.width + child2child / 2;
        }
        int width = fm.stringWidth(n.getDato().toString());

        if (posicionNodos.get(n) == null) {
            contar++;
            posicionNodos.put(n, new Rectangle(center - width / 2 - 3, top, width + 6, fm.getHeight()));
        }

        if (n.getHijo() != null && n.getHijo().getHijo() != null && n.getHijo().getHermano() == null) {
            Rectangle rc = (Rectangle) posicionNodos.get(n.getPadre());
            calcularPosicion(n.getHijo(), left, right, top + fm.getHeight() + parent2child, true, contar);
        } else {
            calcularPosicion(n.getHijo(), Integer.MAX_VALUE, center - child2child / 2, top + fm.getHeight() + parent2child, false, contar);
    }

        if (n.getHijo() != null) {
            calcularPosicion(n.getHijo().getHermano(), center + child2child / 2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child, false, contar);
        }
    }

    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los
     * subárboles calculadas anteriormente.
     *
     * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de
     * las líneas, rectangulos y del String de la información que contiene el
     * NodoB<T>.
     * @param n: Objeto de la clase NodoB <T> que se utiliza como referencia
     * para dibujar el árbol.
     * @param puntox: int con la posición en x desde donde se va a dibujar la
     * línea hasta el siguiente hijo.
     * @param puntoy: int con la posición en y desde donde se va a dibujar la
     * línea hasta el siguiente hijo.
     * @param yoffs: int con la altura del FontMetrics.
     */
    private void dibujarArbol(Graphics2D g, NodoArbol n, int puntox, int puntoy, int yoffs) {
        if (n == null) {
            return;
        }

        Rectangle r = (Rectangle) posicionNodos.get(n);
        g.draw(r);
        g.drawString(n.getDato().toString(), r.x + 3, r.y + yoffs);

        if (puntox != Integer.MAX_VALUE) {
            g.drawLine(puntox, puntoy, (int) (r.x + r.width / 2), r.y);
        }

        dibujarArbol(g, n.getHijo(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);
        if (n.getHijo() != null) {
            dibujarArbol(g, n.getHijo().getHermano(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);
        }

    }

    /**
     * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
     *
     * @param g: Objeto de la clase Graphics.
     */
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();

        if (dirty) {
            calcularPosiciones();
            dirty = false;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, parent2child);
        dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE,
                fm.getLeading() + fm.getAscent());
        fm = null;
    }

}
