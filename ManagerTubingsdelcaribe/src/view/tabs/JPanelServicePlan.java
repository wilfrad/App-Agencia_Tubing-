/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tabs;

/**
 *
 * @author usuario
 */
public class JPanelServicePlan extends javax.swing.JPanel {

    /**
     * Creates new form JpSectionPlan
     */
    public JPanelServicePlan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPlanTitle = new javax.swing.JLabel();
        jLabelClientContact1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(844, 570));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPlanTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelPlanTitle.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPlanTitle.setText("Información del servicio");
        add(jLabelPlanTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 330, 40));

        jLabelClientContact1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelClientContact1.setForeground(new java.awt.Color(51, 51, 51));
        jLabelClientContact1.setText("Contacto :");
        add(jLabelClientContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabelClientContact1;
    public static javax.swing.JLabel jLabelPlanTitle;
    // End of variables declaration//GEN-END:variables
}