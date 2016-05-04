package javaGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public class Mouse extends JFrame implements MouseMotionListener{
	private Image dbImage;
	private Graphics dbg;
	int mx, my;
	boolean mouseDragged;
	
	//Add a new test case
	public Mouse(){
		setSize(400, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
		Rectangle r1 = new Rectangle(mx, my, 25, 25);
		Rectangle r2 = new Rectangle(175, 75, 50, 50);
		g.setColor(Color.RED);
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
		g.setColor(Color.BLUE);
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		
		//Collision
		if(r1.intersects(r2)){
			g.drawString("Collision!!", 175, 75);
		}
		
		repaint();
	}
	
	public static void main(String[] args){
		Mouse mouse = new Mouse();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mx = e.getX() - 10;
		my = e.getY() - 10;
		
		mouseDragged = true;
		
		e.consume();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX() - 10;
		my = e.getY() - 10;
		
		mouseDragged = false;
		
		e.consume();
	}
}
