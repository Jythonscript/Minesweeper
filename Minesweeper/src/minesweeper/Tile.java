//Individual

package minesweeper;

public class Tile {
	
	
	private boolean isHidden;
	
	private boolean isMine;
	
	private int num;
	

	public Tile(boolean hidden, boolean Mine, int num){
		isHidden = hidden;
		isMine = Mine;
		num = num;
		
	}
}
