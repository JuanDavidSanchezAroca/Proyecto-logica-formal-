package co.edu.uniquindio.proyectologica.gui;

import co.edu.uniquindio.proyectologica.excepciones.ValidacionExcepcion;
import co.edu.uniquindio.proyectologica.logica.Principal;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author juan David Sanchez Aroca
 * @author Juan Camilo Correa Pacheco
 * @autor Carlos Cardona
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Atributo que almacena la formula bien formada
     */
    private String formula;
    /**
     * Atributo que representa la clase principal de la logica
     */
    private Principal principal;

    /**
     * Contructor de la ventana principal
     */
    public VentanaPrincipal() {
        initComponents();//Componentes de la interfaz
        principal = new Principal();
        setTitle("CALCULADORA LOGICA");
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jbParentesis = new javax.swing.JButton();
        jbNegadoParentesis = new javax.swing.JButton();
        jbConjuncion = new javax.swing.JButton();
        jbDisyuncion = new javax.swing.JButton();
        jbCondicional = new javax.swing.JButton();
        jbBicondicional = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFormula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbQ = new javax.swing.JButton();
        jbP = new javax.swing.JButton();
        jbS = new javax.swing.JButton();
        jbT = new javax.swing.JButton();
        jbV = new javax.swing.JButton();
        jbW = new javax.swing.JButton();
        jbR = new javax.swing.JButton();
        jbU = new javax.swing.JButton();
        jbX = new javax.swing.JButton();
        jbY = new javax.swing.JButton();
        jbZ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jbLimpiar = new javax.swing.JButton();
        jbValidar = new javax.swing.JButton();
        jbTablaVerdad = new javax.swing.JButton();
        jbManualAyuda = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbParentesis.setText("( )");
        jbParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbParentesisActionPerformed(evt);
            }
        });

        jbNegadoParentesis.setText("¬( )");
        jbNegadoParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNegadoParentesisActionPerformed(evt);
            }
        });

        jbConjuncion.setText("( )˄( )");
        jbConjuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConjuncionActionPerformed(evt);
            }
        });

        jbDisyuncion.setText("( )˅( )");
        jbDisyuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDisyuncionActionPerformed(evt);
            }
        });

        jbCondicional.setText("( )→( )");
        jbCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCondicionalActionPerformed(evt);
            }
        });

        jbBicondicional.setText("( )↔( )");
        jbBicondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBicondicionalActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTFormula);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Alfabeto ");

        jbQ.setText("q");
        jbQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQActionPerformed(evt);
            }
        });

        jbP.setText("p");
        jbP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPActionPerformed(evt);
            }
        });

        jbS.setText("s");
        jbS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSActionPerformed(evt);
            }
        });

        jbT.setText("t");
        jbT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTActionPerformed(evt);
            }
        });

        jbV.setText("v");
        jbV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVActionPerformed(evt);
            }
        });

        jbW.setText("w");
        jbW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWActionPerformed(evt);
            }
        });

        jbR.setText("r");
        jbR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRActionPerformed(evt);
            }
        });

        jbU.setText("u");
        jbU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUActionPerformed(evt);
            }
        });

        jbX.setText("x");
        jbX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXActionPerformed(evt);
            }
        });

        jbY.setText("y");
        jbY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbYActionPerformed(evt);
            }
        });

        jbZ.setText("z");
        jbZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Operadores logicos ");

        jbLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbValidar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbValidar.setText("Validar");
        jbValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbValidarActionPerformed(evt);
            }
        });

        jbTablaVerdad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbTablaVerdad.setText("Tabla de verdad");
        jbTablaVerdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTablaVerdadActionPerformed(evt);
            }
        });

        jbManualAyuda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbManualAyuda.setText("Manual de ayuda");
        jbManualAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManualAyudaActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/uniquindio/proyectologica/gui/imagenes/logout.png"))); // NOI18N
        jbSalir.setText("salir ");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbP, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                            .addComponent(jbS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbQ, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jbT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbR)
                                    .addComponent(jbU)
                                    .addComponent(jbX))))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbConjuncion)
                                    .addComponent(jbParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbNegadoParentesis)
                                    .addComponent(jbDisyuncion)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbCondicional)
                                .addGap(18, 18, 18)
                                .addComponent(jbBicondicional))
                            .addComponent(jLabel2))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(jbValidar)
                        .addGap(18, 18, 18)
                        .addComponent(jbTablaVerdad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbManualAyuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbParentesis)
                            .addComponent(jbNegadoParentesis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbDisyuncion)
                            .addComponent(jbConjuncion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCondicional)
                            .addComponent(jbBicondicional)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbQ)
                            .addComponent(jbP)
                            .addComponent(jbR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbS)
                            .addComponent(jbT)
                            .addComponent(jbU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbV)
                            .addComponent(jbW)
                            .addComponent(jbX))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbY)
                            .addComponent(jbZ)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiar)
                    .addComponent(jbValidar)
                    .addComponent(jbTablaVerdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbManualAyuda)
                    .addComponent(jbSalir))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que escribe un par de parentesis ( )
     *
     * @param evt evento del boton
     */
    private void jbParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbParentesisActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            formula = jbParentesis.getText();
            jTFormula.setText(formula);
            jbParentesis.setEnabled(false);
        }
    }//GEN-LAST:event_jbParentesisActionPerformed

    /**
     * Metodo que escribe la forma de disyuncion de una proposicional
     *
     * @param evt evento del boton
     */
    private void jbDisyuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDisyuncionActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese primero () o ¬()");
        } else {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += jbDisyuncion.getText();
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jbDisyuncionActionPerformed

    /**
     * Metodo que agrega la letra U en la formula
     *
     * @param evt evento del boton
     */
    private void jbUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUActionPerformed
        String letra = jbU.getText();
        agregarLetra(letra);
    }//GEN-LAST:event_jbUActionPerformed
    /**
     * Metodo que agrega la letra Z en la formula
     *
     * @param evt evento del boton
     */
    private void jbZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZActionPerformed
        String letra = jbZ.getText();
        agregarLetra(letra);
    }//GEN-LAST:event_jbZActionPerformed
    /**
     * Metodo que agrega negado parentesis en la formula
     *
     * @param evt evento del boton
     */
    private void jbNegadoParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNegadoParentesisActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            formula = jbNegadoParentesis.getText();
            jTFormula.setText(formula);
            jbParentesis.setEnabled(false);
        } else if (formula.equals(jbParentesis.getText())) {
            formula = jbNegadoParentesis.getText();
            jTFormula.setText(formula);

        } else {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += jbNegadoParentesis.getText();
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        }

    }//GEN-LAST:event_jbNegadoParentesisActionPerformed
    /**
     * Metodo que agrega la conjuncion en la formula
     *
     * @param evt evento del boton
     */
    private void jbConjuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConjuncionActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese primero () o ¬()");
        } else {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += jbConjuncion.getText();
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        }


    }//GEN-LAST:event_jbConjuncionActionPerformed
    /**
     * Metodo que agrega letra P en la formula
     *
     * @param evt evento del boton
     */
    private void jbPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPActionPerformed
        try {
            String letra = jbP.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }

    }//GEN-LAST:event_jbPActionPerformed
    /**
     * Metodo que agrega la leltra Q en la formula
     *
     * @param evt evento del boton
     */

    private void jbQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQActionPerformed
        try {
            String letra = jbQ.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbQActionPerformed
    /**
     * Metodo que agrega la leltra R en la formula
     *
     * @param evt evento del boton
     */
    private void jbRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRActionPerformed
        try {
            String letra = jbR.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbRActionPerformed
    /**
     * Metodo que agrega la leltra S en la formula
     *
     * @param evt evento del boton
     */
    private void jbSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSActionPerformed
        try {
            String letra = jbS.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbSActionPerformed
    /**
     * Metodo que agrega la leltra T en la formula
     *
     * @param evt evento del boton
     */
    private void jbTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTActionPerformed
        try {
            String letra = jbT.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbTActionPerformed
/**
     * Metodo que agrega la leltra V en la formula
     *
     * @param evt evento del boton
     */
    private void jbVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVActionPerformed
        try {
            String letra = jbV.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbVActionPerformed
/**
     * Metodo que agrega la leltra W en la formula
     *
     * @param evt evento del boton
     */
    private void jbWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWActionPerformed
        try {
            String letra = jbW.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbWActionPerformed
/**
     * Metodo que agrega la leltra X en la formula
     *
     * @param evt evento del boton
     */
    private void jbXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXActionPerformed
        try {
            String letra = jbX.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbXActionPerformed
/**
     * Metodo que agrega la leltra Y en la formula
     *
     * @param evt evento del boton
     */
    private void jbYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbYActionPerformed
        try {
            String letra = jbY.getText();
            agregarLetra(letra);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ingrese primero ( ) o ¬( )");
        }
    }//GEN-LAST:event_jbYActionPerformed
/**
     * Metodo que agrega el condicional en la formula
     *
     * @param evt evento del boton
     */
    private void jbCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCondicionalActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese primero () o ¬()");
        } else {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += jbCondicional.getText();
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jbCondicionalActionPerformed
/**
     * Metodo que agrega el bicondicional en la formula
     *
     * @param evt evento del boton
     */
    private void jbBicondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBicondicionalActionPerformed
        formula = jTFormula.getText();
        if (formula.equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese primero () o ¬()");
        } else {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += jbBicondicional.getText();
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jbBicondicionalActionPerformed
/**
     * Metodo que elimina los datos del visor de formulas
     *
     * @param evt evento del boton
     */
    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        jTFormula.setText("");
        formula = jTFormula.getText();
        jbParentesis.setEnabled(true);
    }//GEN-LAST:event_jbLimpiarActionPerformed
/**
     * Metodo que invoca la validacion de una formula
     *
     * @param evt evento del boton
     */
    private void jbValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbValidarActionPerformed
        try {
            formula = jTFormula.getText();
            principal.validarFuncion(formula);
            JOptionPane.showMessageDialog(null, "formula bien formada");
        } catch (ValidacionExcepcion e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jbValidarActionPerformed
/**
     * Metodo que cierra el programa
     *
     * @param evt evento del boton
     */
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed
/**
     * Metodo que dirige a la tabla de verdad
     *
     * @param evt evento del boton
     */
    private void jbTablaVerdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTablaVerdadActionPerformed

        try {
            principal.validarFuncion(formula);
            VentanaTabla v = new VentanaTabla(formula);
            this.dispose();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese información");
            e.printStackTrace();
        } catch (ValidacionExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jbTablaVerdadActionPerformed
/**
     * Metodo que abre el manual de la calculadora
     *
     * @param evt evento del boton
     */
    private void jbManualAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManualAyudaActionPerformed
        try {
            principal.abrirDocumento();
        } catch (IOException ex) {
            System.out.println("Problema abriendo el pdf de erfc");
        }


    }//GEN-LAST:event_jbManualAyudaActionPerformed

    /**
     * Metodo que agrega una letra a una formula proposicional
     * @param letra
     */
    public void agregarLetra(String letra) {
        try {
            String cadena1;
            String cadena2;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '(' && formula.charAt(i + 2) == ')' && formula.charAt(i + 1) == ' ') {
                    cadena1 = formula.substring(0, i + 1);
                    cadena2 = formula.substring(i + 2, formula.length());
                    cadena1 += letra;
                    formula = cadena1 + cadena2;
                    jTFormula.setText(formula);
                    break;
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ingrese primero () o ¬()");
        }

    }

    /**
     * Metodo de ejecucion del programa
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTFormula;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbBicondicional;
    private javax.swing.JButton jbCondicional;
    private javax.swing.JButton jbConjuncion;
    private javax.swing.JButton jbDisyuncion;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbManualAyuda;
    private javax.swing.JButton jbNegadoParentesis;
    private javax.swing.JButton jbP;
    private javax.swing.JButton jbParentesis;
    private javax.swing.JButton jbQ;
    private javax.swing.JButton jbR;
    private javax.swing.JButton jbS;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbT;
    private javax.swing.JButton jbTablaVerdad;
    private javax.swing.JButton jbU;
    private javax.swing.JButton jbV;
    private javax.swing.JButton jbValidar;
    private javax.swing.JButton jbW;
    private javax.swing.JButton jbX;
    private javax.swing.JButton jbY;
    private javax.swing.JButton jbZ;
    // End of variables declaration//GEN-END:variables
}
