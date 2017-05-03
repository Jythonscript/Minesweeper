//Jframe that displays 
package minesweeper;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Screen extends JFrame implements Runnable{

	public void run() {
		
		try {
			
			while (true) {
				
				
				
			}
			
		}
		catch(Exception e) {
			
			System.out.println("Error in thread: " + e.getMessage());
			
		}
		
	}
	
	public void paint(Graphics g) {
		
		
		
	}
	
	public Screen() {
		
		setVisible(true);
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
