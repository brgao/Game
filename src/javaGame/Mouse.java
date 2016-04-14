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
		if(mouseDragged){
			g.setColor(Color.darkGray);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.lightGray);
			g.fillRect(mx, my, 20, 20);
		}
		else{
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.darkGray);
			g.fillRect(mx, my, 20, 20);
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
