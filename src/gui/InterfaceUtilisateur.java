package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceUtilisateur extends JFrame
{
    
    public InterfaceUtilisateur()
    {
        this.setTitle("Interface joueur");
        this.setSize(400, 35);
        // placement au centre
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.setResizable(false); 
        this.setUndecorated(true);
       
        JPanel panel = new JPanel();
        panel.setLocation(150, 150);
        this.setContentPane(panel);   

        
        this.setVisible(true); 
    }
    
    
}
