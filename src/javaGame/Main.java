package javaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Main extends JFrame {
 
    Dimension dimension = new Dimension(400, 300);
 
    //Double buffering
    Image dbImage;
    Graphics dbg;
    
    //Ball objects
    static Ball b = new Ball(193, 143);
    
    
    public Main() {
        setSize(dimension);
        setResizable(false);
        setTitle("Pong");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
        addKeyListener(new AC());
    }
 
    public class AC extends KeyAdapter {
 
        public void keyPressed(KeyEvent e) {
 
        }
 
        public void keyReleased(KeyEvent e) {
 
        }
    }
 
    public static void main(String[] args) {
        Main core = new Main();
        //Create and start threads
        Thread ball = new Thread(b);
        ball.start();
    }
    @Override
    public void paint(Graphics g){
    	dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage,  0,  0, this);
    }
    
    
    public void draw(Graphics g){
    	b.draw(g);
    	
    	repaint();
    }
}