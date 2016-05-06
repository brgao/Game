package javaGame;

import java.awt.*;
import java.awt.event.*;

public class Ship implements Runnable {
    
    int x,y, xDirection;
    boolean readyToFire, shot = false;
    
    int bx, by;
    Rectangle bullet; 
    
    public Ship(){
        x = 175;
        y = 275;
    }
    
    public void draw (Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 10);
        g.fillRect(x+18, y-7, 4, 7);
        if(shot){
        	g.setColor(Color.BLACK);
        	g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }
    }
    public void move(){
        x += xDirection;
        if(x <= 0)
            x = 5;
        if (x >= 360)
            x = 355;
    }
    
    public void shoot(){
    	if(shot){
    		bullet.y--;
    	}
    }
    
    public void setXDirection(int xdir){
        xDirection = xdir;
    }
    
    public void keyPressed (KeyEvent e){
       int keyCode = e.getKeyCode();
       if (keyCode == e.VK_LEFT){
           setXDirection(-1);
        }
       if (keyCode == e.VK_RIGHT){
           setXDirection(1);
        }
       if (keyCode == e.VK_SPACE){
           if(bullet == null){
        	   readyToFire = true;
           }
           if(readyToFire){
        	   by = y - 7;
        	   bx = x + 18;
        	   bullet = new Rectangle(bx, by, 3, 5);
        	   shot = true;
           }
       }
    }
    //comment
    public void keyReleased (KeyEvent e){
        int keyCode = e.getKeyCode();
        if (keyCode ==e.VK_LEFT){
            setXDirection(0);
        }
        if (keyCode == e.VK_RIGHT){
            setXDirection(0);
        }    
        if(keyCode == e.VK_SPACE){
            readyToFire = false;
            if(bullet.y <= 2){
            	bullet = new Rectangle(0, 0, 0, 0);
            	shot = false;
            	readyToFire = true;
            }
        }
    }
    
    @Override
    public void run(){
        try{
            while (true){
            	shoot();
                move();
                Thread.sleep(5);
            }
       }
        catch(Exception e) {System.err.println(e.getMessage());}     
    }
}

