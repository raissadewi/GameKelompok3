package Cobain;

import java.awt.Image;
import java.awt.Toolkit;
import whack_a_mole.Audio;
import whack_a_mole.Game;
import whack_a_mole.Hard;
import whack_a_mole.Medium;


/**
 *
 * @author Vivobook
 */
public class coba2 extends javax.swing.JFrame {

    /**
     * Creates new form coba2
     */
    public coba2() {
        initComponents();
        this.setTitle("Game Dino");
        this.setVisible(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/Cobain/dino-awal.png");
        setIconImage(icon);
        Audio backgroundMusic = new Audio("src\\res\\cull.wav");
        backgroundMusic.play();
    }
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        easy = new javax.swing.JButton();
        hard = new javax.swing.JButton();
        medium = new javax.swing.JButton();
        dinoawal = new javax.swing.JLabel();
        textawal = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        easy.setBackground(new java.awt.Color(255, 255, 153));
        easy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        easy.setForeground(new java.awt.Color(51, 102, 0));
        easy.setText("EASY");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });
        jPanel1.add(easy, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, 50));

        hard.setBackground(new java.awt.Color(255, 153, 153));
        hard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        hard.setForeground(new java.awt.Color(51, 102, 0));
        hard.setText("HARD");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });
        jPanel1.add(hard, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 160, 50));

        medium.setBackground(new java.awt.Color(255, 204, 0));
        medium.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        medium.setForeground(new java.awt.Color(51, 102, 0));
        medium.setText("MEDIUM");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });
        jPanel1.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 160, 50));

        dinoawal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cobain/dino-awal.png"))); // NOI18N
        dinoawal.setText("jLabel2");
        dinoawal.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Cobain/dino-awal.png"))); // NOI18N
        jPanel1.add(dinoawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, 460, 370));

        textawal.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        textawal.setForeground(new java.awt.Color(102, 153, 0));
        textawal.setText("GAME DINO");
        jPanel1.add(textawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cobain/bg-tanah_1.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 436, 420));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 430, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardActionPerformed
        Hard frame = new Hard();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hardActionPerformed

    private void easyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyActionPerformed
        Game frame = new Game();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_easyActionPerformed

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumActionPerformed
        Medium frame = new Medium();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mediumActionPerformed

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
            java.util.logging.Logger.getLogger(coba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(coba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(coba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(coba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coba2().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel dinoawal;
    private javax.swing.JButton easy;
    private javax.swing.JButton hard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton medium;
    private javax.swing.JLabel textawal;
    // End of variables declaration//GEN-END:variables
}