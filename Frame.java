
package Movetest;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class Frame extends JFrame{
    
    private final Screen screen;
    
    float player_posx = 300;
    float player_posy = 300;
    private final int player_size =50;
    
    private boolean key_up = false;
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;
    
    public Frame (){
        super ("MoveTest");
        screen= new Screen();
        screen.setBounds(0, 0, 800, 600);
        Component add = add(screen);
        addKeyListener(new KeyHandler());
    }  
    
    
    public boolean getUp(){
        return key_up;
    }
    public boolean getDown(){
        return key_down;
    }
    public boolean getLeft(){
        return key_left;
    }
    public boolean getRight(){
        return key_right;
    }
    
    
    public void repaintScreen(){
        screen.repaint();
    }
    
    
    private class Screen extends JLabel{
        
        protected void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect((int)player_posx, (int)player_posy, player_size, player_size);
        
    }
    private class KeyHandler implements KeyListener{    

        
            //Unnötig
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            //Unnötig

            @Override
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_S) key_down = true;
                if(e.getKeyCode() == KeyEvent.VK_W) key_up = true;
                if(e.getKeyCode() == KeyEvent.VK_D) key_right = true;
                if(e.getKeyCode() == KeyEvent.VK_A) key_left = true;
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_S) key_down = false;
                if(e.getKeyCode() == KeyEvent.VK_W) key_up = false;
                if(e.getKeyCode() == KeyEvent.VK_D) key_right = false;
                if(e.getKeyCode() == KeyEvent.VK_A) key_left = false;    
            }
        
    
    }
}
    
    
