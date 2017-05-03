//Jframe that displays 
package minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Screen extends JFrame implements Runnable{

	//double buffering
	private Image dbImage;
	private Graphics dbg;
	
	//screen dimensions variables
	private final int SCREENX = 800, SCREENY = 500;
	
	//mouse x and y variables
	private int mouseX, mouseY;
	
	//the thread
	public void run() {
		
		try {
			
			while (true) {
				
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Error in thread: " + e.getMessage());
		}
		
	}
	
	//mouse input
	public class Mouse extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
			mouseX = e.getX();
			mouseY = e.getY();
			
			System.out.println("Mouse X: " + mouseX + " Mouse Y: " + mouseY);
			
		}
		
	}
	
	//key input
	public class Keyboard extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if (key == e.VK_Q) {
				System.exit(0);
			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();
			
		}
		
	}
	
	//the default constructor, creates JFrame
	public Screen() {
		
		//mouse listener
		addMouseListener(new Mouse());
		
		//key listener
		addKeyListener(new Keyboard());
		
		setTitle("Minesweeper");
		setVisible(true);
		setSize(SCREENX, SCREENY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	
}
