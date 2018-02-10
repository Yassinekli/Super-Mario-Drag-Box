/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.io.File;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import static mario.DrawComponent.Drawable.scaledImage;

/**
 *
 * @author Yassine
 */
public class GameMenu extends JFrame {

    /**
     * Creates new form GameMenu
     * @throws java.io.IOException
     */
    public GameMenu() throws IOException {
        initComponents();
        
        ImageIcon icon = new ImageIcon(
                        scaledImage(ImageIO.read(new File("Elements\\Mario Right.png"))
                        , MARIO_MENU_IMAGE.getWidth()
                        , MARIO_MENU_IMAGE.getHeight()));
        MARIO_MENU_IMAGE.setIcon(icon);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MARIO_MENU_IMAGE = new javax.swing.JLabel();
        btnStartGame = new javax.swing.JButton();
        btnExitGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(403, 340));
        getContentPane().setLayout(null);

        MARIO_MENU_IMAGE.setName(""); // NOI18N
        getContentPane().add(MARIO_MENU_IMAGE);
        MARIO_MENU_IMAGE.setBounds(147, 30, 120, 150);

        btnStartGame.setText("Start The Game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartGame);
        btnStartGame.setBounds(140, 190, 130, 32);

        btnExitGame.setText("Exit The Game");
        btnExitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnExitGame);
        btnExitGame.setBounds(140, 230, 130, 32);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        try {
            
            new PlayingFrame().setVisible(true);
            this.dispose();
            
        } catch (IOException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnExitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitGameActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitGameActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GameMenu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MARIO_MENU_IMAGE;
    private javax.swing.JButton btnExitGame;
    private javax.swing.JButton btnStartGame;
    // End of variables declaration//GEN-END:variables

}
