//Jframe that displays 
package minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Screen extends JFrame implements Runnable{

	private Image dbImage;
	private Graphics dbg;
	
	private int screenX = 800;
	private int screenY = 500;
	
	public void run() {
		
		try {
			
			while (true) {
				
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Error in thread: " + e.getMessage());
		}
		
	}
	
	//printing stuff to the screen
	public void paintComponent(Graphics g) {
		
		g.drawString("Test string", 100, 100);
		repaint();
		
	}
	
	//double buffering
	public void paint(Graphics g) {
		
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	public Screen() {
		
		setTitle("Minesweeper");
		setVisible(true);
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
