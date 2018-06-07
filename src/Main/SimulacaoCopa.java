/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class SimulacaoCopa extends javax.swing.JFrame {

    public String voitavas1 = "";
    String voitavas2 = "";
    String voitavas3 = "";
    String voitavas4 = "";
    String voitavas5 = "";
    String voitavas6 = "";
    String voitavas7 = "";
    String voitavas8 = "";
    String vquartas1 = "";
    String vquartas2 = "";
    String vquartas3 = "";
    String vquartas4 = "";
    String vsemi1 = "";
    String vsemi2 = "";
    String camp = "";
    
    public SimulacaoCopa() {
        initComponents();
        simulacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oitavas5 = new javax.swing.JTextField();
        oitavas2 = new javax.swing.JTextField();
        oitavas3 = new javax.swing.JTextField();
        oitavas4 = new javax.swing.JTextField();
        oitavas1 = new javax.swing.JTextField();
        oitavas7 = new javax.swing.JTextField();
        oitavas8 = new javax.swing.JTextField();
        oitavas6 = new javax.swing.JTextField();
        quartas1 = new javax.swing.JTextField();
        quartas2 = new javax.swing.JTextField();
        quartas4 = new javax.swing.JTextField();
        quartas3 = new javax.swing.JTextField();
        semi2 = new javax.swing.JTextField();
        semi1 = new javax.swing.JTextField();
        Final = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oitavas5.setEditable(false);
        oitavas5.setText("Oitavas 5");

        oitavas2.setEditable(false);
        oitavas2.setText("Oitavas 2");

        oitavas3.setEditable(false);
        oitavas3.setText("Oitavas 3");

        oitavas4.setEditable(false);
        oitavas4.setText("Oitavas 4");

        oitavas1.setText("Oitavas 1");

        oitavas7.setEditable(false);
        oitavas7.setText("Oitavas 7");

        oitavas8.setEditable(false);
        oitavas8.setText("Oitavas 8");

        oitavas6.setEditable(false);
        oitavas6.setText("Oitavas 6");

        quartas1.setText("Quartas 1");

        quartas2.setText("Quartas 2");

        quartas4.setText("Quartas 4");

        quartas3.setText("Quartas 3");

        semi2.setText("Semi-final 2");

        semi1.setText("Semi-final 1");

        Final.setEditable(false);
        Final.setText("Campeão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(oitavas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oitavas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oitavas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oitavas7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oitavas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oitavas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quartas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quartas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                                        .addComponent(semi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addComponent(semi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(quartas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quartas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oitavas8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oitavas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oitavas5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oitavas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quartas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quartas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oitavas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oitavas8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oitavas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oitavas7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quartas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quartas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oitavas4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oitavas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void simulacao(){
        //Controller c = new Controller();
        try {
            String campeao = simularCopaInteria();
            
            oitavas5.setText(voitavas1);
            oitavas2.setText(voitavas2);
            oitavas3.setText(voitavas3);
            oitavas4.setText(voitavas4);
            oitavas1.setText(voitavas5);
            oitavas7.setText(voitavas6);
            oitavas8.setText(voitavas7);
            oitavas6.setText(voitavas8);
            quartas1.setText(vquartas1);
            quartas2.setText(vquartas2);
            quartas4.setText(vquartas3);
            quartas3.setText(vquartas4);
            semi1.setText(vsemi1);
            semi2.setText(vsemi2);
            Final.setText(campeao);
            
        } catch (SQLException ex) {
            System.out.println("ERRO! "+ ex);
        }
    }
    
    public String simularCopaInteria() throws SQLException{
        
        //SimulacaoCopa s = new SimulacaoCopa();
        Controller co = new Controller();
        
        ArrayList<String> classificadosGrupoA = co.grupoA();
        ArrayList<String> classificadosGrupoB = co.grupoB();
        ArrayList<String> classificadosGrupoC = co.grupoC();
        ArrayList<String> classificadosGrupoD = co.grupoD();
        ArrayList<String> classificadosGrupoE = co.grupoE();
        ArrayList<String> classificadosGrupoF = co.grupoF();
        ArrayList<String> classificadosGrupoG = co.grupoG();
        ArrayList<String> classificadosGrupoH = co.grupoH();
        
//        System.out.println(classificadosGrupoA);
//        System.out.println(classificadosGrupoB);
//        System.out.println(classificadosGrupoC);
//        System.out.println(classificadosGrupoD);
//        System.out.println(classificadosGrupoE);
//        System.out.println(classificadosGrupoF);
//        System.out.println(classificadosGrupoG);
//        System.out.println(classificadosGrupoH);
        
        
        //return "";
        
        ArrayList<String> classficadosOitavas = co.oitavasDeFinal(
                classificadosGrupoA,
                classificadosGrupoB,
                classificadosGrupoC,
                classificadosGrupoD,
                classificadosGrupoE,
                classificadosGrupoF,
                classificadosGrupoG,
                classificadosGrupoH);
        
        voitavas1 = classficadosOitavas.get(0);
        voitavas2 = classficadosOitavas.get(1);
        voitavas3 = classficadosOitavas.get(2);
        voitavas4 = classficadosOitavas.get(3);
        voitavas5 = classficadosOitavas.get(4);
        voitavas6 = classficadosOitavas.get(5);
        voitavas7 = classficadosOitavas.get(6);
        voitavas8 = classficadosOitavas.get(7);
        
        System.out.println("lasjbgjhegbjgbkegfbkjfbgkshdfgblkeh");
        
        
        ArrayList<String> classificadosQuartas = co.quartasDeFinal(
                classficadosOitavas.get(0),
                classficadosOitavas.get(1),
                classficadosOitavas.get(2),
                classficadosOitavas.get(3),
                classficadosOitavas.get(4),
                classficadosOitavas.get(5),
                classficadosOitavas.get(6),
                classficadosOitavas.get(7));
        
        vquartas1 = classificadosQuartas.get(0);
        vquartas2 = classificadosQuartas.get(1);
        vquartas3 = classificadosQuartas.get(2);
        vquartas4 = classificadosQuartas.get(3);
        
        ArrayList<String> semiFinais = co.semiFinal(
                classificadosQuartas.get(0),
                classificadosQuartas.get(1),
                classificadosQuartas.get(2),
                classificadosQuartas.get(3));
        
        vsemi1 = semiFinais.get(0);
        vsemi2 = semiFinais.get(1);
        
        String campeao = co.Final(semiFinais.get(0), semiFinais.get(1));
        
        camp = campeao;
        
        //JOptionPane.showMessageDialog(null, "Campeão:. "+ campeao);
        
        return campeao;
        
    }
    
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
            java.util.logging.Logger.getLogger(SimulacaoCopa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulacaoCopa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulacaoCopa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulacaoCopa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulacaoCopa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Final;
    public javax.swing.JTextField oitavas1;
    public javax.swing.JTextField oitavas2;
    public javax.swing.JTextField oitavas3;
    public javax.swing.JTextField oitavas4;
    public javax.swing.JTextField oitavas5;
    public javax.swing.JTextField oitavas6;
    public javax.swing.JTextField oitavas7;
    public javax.swing.JTextField oitavas8;
    public javax.swing.JTextField quartas1;
    public javax.swing.JTextField quartas2;
    public javax.swing.JTextField quartas3;
    public javax.swing.JTextField quartas4;
    public javax.swing.JTextField semi1;
    public javax.swing.JTextField semi2;
    // End of variables declaration//GEN-END:variables
}
