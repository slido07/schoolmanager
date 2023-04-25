/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.bulletin;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HP
 */
public abstract class AbstractPanelBulletin extends JPanel {

    protected javax.swing.JPanel headPanel;
    protected javax.swing.JPanel endPanel;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JTable liste;

    public AbstractPanelBulletin() {

    }

    public boolean[] canEdit(int nbCol) {
        boolean[] canEdit = new boolean[nbCol];
        for (int i = 0; i < nbCol; i++) {
            canEdit[i] = false;
        }
        return canEdit;
    }

    //renvoie un tableau d'objets à partir d'un liste d'objets et du nombre de colonnes du tableau
    public abstract Object[][] tab();

    //renvoie un array des titres des différentes colonnes
    public abstract String[] colTitles();

    //renvoie un array des types de chaque colonne
    public abstract Class[] colTypes();

    //permet de définir le panel d'en-tête de chaque bulletin
    public abstract JPanel headPanel();

    //permet de définir le panel de fin de chaque bulletin
    public abstract JPanel endPanel();

    final protected void initComponents(Object[][] tab) {
        if (tab == null) {
            return;
        }

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liste = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        headPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(500, 300));
        setLayout(new java.awt.BorderLayout());
        setBackground(Color.CYAN);

        String[] titles = colTitles();
        liste.setBackground(new java.awt.Color(255, 255, 204));
        liste.setModel(new javax.swing.table.DefaultTableModel(
                tab, titles
        ) {
            Class[] types = colTypes();
            boolean[] canEdit = canEdit(liste.getColumnCount());

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < liste.getColumnCount(); i++) {
            liste.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        liste.getTableHeader().setResizingAllowed(false);
        liste.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(liste);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 300));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(10, 300));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 172, Short.MAX_VALUE)
        );

        add(jPanel4, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 421, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        add(jPanel5, java.awt.BorderLayout.PAGE_END);

        setHeadPanel(headPanel());
        add(headPanel, java.awt.BorderLayout.PAGE_START);
        setEndPanel(endPanel());
        add(endPanel, java.awt.BorderLayout.PAGE_END);

    }

    public JPanel getHeadPanel() {
        return headPanel;
    }

    public void setHeadPanel(JPanel headPanel) {
        this.headPanel = headPanel;
    }

    public JPanel getEndPanel() {
        return endPanel;
    }

    public void setEndPanel(JPanel endPanel) {
        this.endPanel = endPanel;
    }

}
