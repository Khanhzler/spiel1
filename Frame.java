/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Raphael
 */
public class Frame extends JFrame{
    
    private Screen screen;
    
    final Player player;
    
    private boolean key_up = false;
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;
    
    
    public Frame (Player player){
        super("MoveTest");
        screen = new Screen();
        screen.setBounds(0, 0, 800, 600);
        add(screen);
        addKeyListener(new KeyHandler());
        this.player = player;
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

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            g.setColor(Color.BLUE);
            g.fillRect(player.getBounding().x, player.getBounding().y, player.getBounding().width, player.getBounding().height);
        }
     
    }
    private class KeyHandler implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_S)key_down = true;
            if(e.getKeyCode() == KeyEvent.VK_W)key_up = true;
            if(e.getKeyCode() == KeyEvent.VK_D)key_right = true;
            if(e.getKeyCode() == KeyEvent.VK_A)key_left = true;
        }
        

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_S)key_down = false;
            if(e.getKeyCode() == KeyEvent.VK_W)key_up = false;
            if(e.getKeyCode() == KeyEvent.VK_D)key_right = false;
            if(e.getKeyCode() == KeyEvent.VK_A)key_left = false;
        }
        //Wird nicht benötigt
        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
