/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;

/**
 *
 * @author Antonio
 */
class InterfaceMorpion extends JFrame
{
    
   public InterfaceMorpion()
   {
       //JFrame f = new JFrame();
       this.setTitle("Morpion");
       
       InterfaceGomoku gomoku = new InterfaceGomoku();
       this.add(gomoku);
       int size = gomoku.fin_marge + InterfaceGomoku.marge;
       this.setSize(size +6, size +28);
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //gomoku.nb_lignes = 3;
       this.setVisible(true);     
   }
}
