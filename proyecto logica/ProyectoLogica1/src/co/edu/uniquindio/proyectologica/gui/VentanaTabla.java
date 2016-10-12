package co.edu.uniquindio.proyectologica.gui;

import co.edu.uniquindio.proyectologica.logica.Principal;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * Vetana que muetsra la tabla de verdad de una proposicion
 *
 * @author juan David Sanchez Aroca
 * @author camilo Correa Pacheco
 * @author Carlos Alberto Cardona Pacheco
 *
 */
public class VentanaTabla extends JFrame implements ActionListener {

    /**
     * Atributos de la clase
     */
    private JPanel panel;
    private JTable tabla;
    private JTableHeader encabezado;
    private JScrollPane scroll;
    private JScrollPane scrollTexto;
    private JTextField texto;
    private Principal principal;
    private String funcion;
    private JButton boton, arbolSub, conjuntoSub, satisfacibilidad;
    private JLabel titulo;
    private String ultimoDato;
    private Map<String, ArrayList<Integer>> mapa;

    /**
     * Constructor de la ventana tabla
     *
     * @param funcion funcion proposicional
     */
    public VentanaTabla(String funcion) {
        this.funcion = funcion;
        principal = new Principal();
        principal.contarProposiciones(funcion);
        componentes();
    }//Cierre del constructor 

    /**
     * Metodo que modela la tabla de verdad
     *
     * @return table model (modelo de la tabla )
     */
    public TableModel toTableModel() {

        HashMap<String, ArrayList<Integer>> mapa1 = principal.getMapa();
        mapa = principal.ordenarMapa(mapa1);
        ArrayList<Integer> n;
        String nombres[] = new String[mapa.size()];
        String datos[][] = new String[(int) Math.pow(2, principal.getC().size())][mapa.size()];
        int c = 0;
        for (Map.Entry<String, ArrayList<Integer>> s : mapa.entrySet()) {
            nombres[c] = s.getKey();
            n = mapa.get(s.getKey());

            for (int i = 0; i < (int) Math.pow(2, principal.getC().size()); i++) {
                datos[i][c] = String.valueOf(n.get(i));
            }
            c++;
        }
        ultimoDato = nombres[mapa.size()-1];
        DefaultTableModel model = new DefaultTableModel(datos, nombres);

        return model;
    }

    /**
     * Metodo que contiene los componenetes de la ventana tabla
     */
    public void componentes() {
        this.setLayout(null);
        this.tabla = new JTable(toTableModel());
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //TableColumnModel columnModel = tabla.getColumnModel();
        tabla.setPreferredScrollableViewportSize(new Dimension(400, 400));
        tabla.setFillsViewportHeight(true);
        actualizar();
        tabla.setEnabled(false);
        this.encabezado = this.tabla.getTableHeader();
        this.scroll = new JScrollPane(this.tabla);
        this.scroll.setSize(350, 350);

        texto = new JTextField(funcion);
        texto.setEditable(false);
        scrollTexto = new JScrollPane(texto);
        scrollTexto.setBounds(50, 45, 400, 50);
        add(scrollTexto);

        titulo = new JLabel("VENTANA TABLA");
        titulo.setFont(new java.awt.Font("Tahoma", 0, 18));
        titulo.setBounds(150, 10, 200, 30);
        add(titulo);

        boton = new JButton(" Atras");
        boton.setBounds(420, 550, 100, 30);
        boton.addActionListener(this);
        add(boton);

        arbolSub = new JButton("Arbol subformula");
        arbolSub.setBounds(220, 550, 180, 30);
        arbolSub.addActionListener(this);
        add(arbolSub);

        conjuntoSub = new JButton("Conjunto subformula");
        conjuntoSub.setBounds(20, 550, 180, 30);
        conjuntoSub.addActionListener(this);
        add(conjuntoSub);

        satisfacibilidad = new JButton("Satisfacibilidad");
        satisfacibilidad.setBounds(20, 580, 150, 30);
        satisfacibilidad.addActionListener(this);
        add(satisfacibilidad);

        panel = new JPanel();
        panel.setBounds(8, 100, 400, 500);
        panel.setSize(500, 500);
        panel.add(scroll);
        getContentPane().add(panel);

        setSize(550, 650);
        setResizable(true);
        setTitle("Tabla logica");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Metodo que contiene los eventos de action Listener
     *
     * @param e evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            VentanaPrincipal x = new VentanaPrincipal();
            x.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == arbolSub) {

            ArbolExpresionGrafico x = new ArbolExpresionGrafico(principal.getOperacion().getArbol());
        }

        if (e.getSource() == conjuntoSub) {
            ArrayList<String> x = principal.getConjuntoSub();
            String formula = "{ ";
            for (int i = 0; i < x.size(); i++) {
                formula += x.get(i) + " ,";
            }
            formula += " }";

            JOptionPane.showMessageDialog(null, formula);
        }

        if (e.getSource() == satisfacibilidad) {

            ArrayList<Integer> x = mapa.get(ultimoDato);
            if (x.contains(1)) {
                JOptionPane.showMessageDialog(null, "la formula es satisfacible");
            } else {
                JOptionPane.showMessageDialog(null, "la formula no es satisfacible");
            }
        }
    }

    /**
     * Metodo que ajusta el tamaño de la tabla
     */
    private void actualizar() {

        ajustarTamaColumna(tabla);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            ajustarTama(tabla, i, 2);
        }
    }

    /**
     * Metodo que ajusta el tamaño de las columnas
     */
    private void ajustarTamaColumna(JTable jTable) {
        for (int row = 0; row < jTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
                Object valueAt = jTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            jTable.setRowHeight(row, maxHeight);
        }

    }

    /**
     * Metodo que encargado de la logica para ajustar tamaño de la tabla
     */
    public void ajustarTama(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;

        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }

        width += 2 * margin;

        col.setPreferredWidth(width);
        col.setWidth(width);
    }

}
