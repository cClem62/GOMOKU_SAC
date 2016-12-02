package gomoku_sac.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceUtilisateur extends JFrame
{
    
    public InterfaceUtilisateur()
    {
        this.setTitle("Interface joueur");
        this.setSize(400, 35);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.setResizable(false); 
        this.setUndecorated(true);
       
        JPanel panel = new JPanel();
        this.setContentPane(panel);   

        
        this.setVisible(true); 
    }
    
    
}
