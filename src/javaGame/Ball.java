package javaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {
	
	//Global variables
	int x, y, xDirection, yDirection;
	Rectangle ball;
	
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
		//Set ball moving randomly 
		Random r = new Random();
		int rDir = r.nextInt(2);
		if(rDir == 0){
			rDir--;
		}
		setXDirection(rDir);
		int yrDir = r.nextInt(2);
		if(yrDir == 0){
			yrDir--;
		}
		setYDirection(yrDir);
		//Create 'ball'
		ball = new Rectangle(this.x, this.y, 15, 15);
	}
	
	public void setXDirection(int xdir){
		xDirection = xdir;
	}
	public void setYDirection(int ydir){
		yDirection = ydir;
	}
	
	public void move(){
		ball.x += xDirection;
		ball.y += yDirection;
		//Bounce the ball when edge is detected
		if(ball.x <= 0){
			setXDirection(+1);
			//Add to score
		}
		if(ball.x >= 385){
			setXDirection(-1);
			//Add to score
		}
		if(ball.y <= 23){
			setYDirection(+1);
		}
		if(ball.y >= 285){
			setYDirection(-1);
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}
	
	@Override
	public void run(){
		try{
			while(true){
				move();
				Thread.sleep(6);
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
