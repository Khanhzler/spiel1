/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author info
 */
public class MoveTest {
    public static void main(String[] args) {
        
        Player player = new Player(300, 300, 50);
        
        Frame f = new Frame(player);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setResizable(true);    //Ich möchte das Fenster vergrößern können
        
        
        while(true){
            player.update(f.getUp(), f.getDown(), f.getLeft(), f.getRight());    
            
            
            f.repaintScreen();
            
            
            
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoveTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
