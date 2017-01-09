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
 * interface qui regroupe le plateau Gomoku (plateau + gomoku)
 */
public class Interface 
{
    private static final int size = InterfaceGomoku.posDebutQuadrillage + InterfaceGomoku.posFinQuadrillage;
    
   
    public static void main(String args[]) 
    {
        JFrame f = new JFrame();
        f.setTitle("Gomoku");
        
        InterfaceGomoku gomoku = new InterfaceGomoku();
        f.add(gomoku);
        
        f.setSize(size, size);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
