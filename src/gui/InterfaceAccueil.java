package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Clément Cantraine
 */
    public class InterfaceAccueil extends JFrame implements ActionListener{

        private JButton btnIA = new JButton("Gomoku contre l'Intelligence Artificielle");
        private JButton btnA = new JButton("Gomoku contre un ami");
        private JPanel pn1 = new JPanel();
         public void actionPerformed(ActionEvent e) {
        if ((JButton)e.getSource() == btnIA){
          Interface fenetre = new Interface();
        }else if ((JButton)e.getSource() == btnA){
              Interface fenetre = new Interface();
                }
        this.dispose();
        this.setVisible(false);
      }   
   
    public InterfaceAccueil(){
        this.setTitle("Accueil : Comment jouez vous ?");
        this.setSize(800, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        btnIA.addActionListener(this);
        btnA.addActionListener(this);
        pn1.add(btnIA);
        pn1.add(btnA);
        this.setContentPane(pn1);
        this.setVisible(true);
    }

}
