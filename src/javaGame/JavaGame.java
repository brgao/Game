package javaGame;

import java.awt.Graphics;
import javax.swing.JFrame;

public class JavaGame extends JFrame{
	
	public JavaGame(){
		setTitle("Java Game");
		setSize(250, 250);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		g.drawString("Hello World", 75, 75);
	}
	
	public static void main(String[] args){
		new JavaGame();
	}
	
	
	
}
