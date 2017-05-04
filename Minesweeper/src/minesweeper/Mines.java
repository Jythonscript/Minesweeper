package minesweeper;

//The 2d grid of
public class Mines {
	public Tile[][] tiles;
	//public Tile(boolean h, boolean m, int n){
	//0 = open 9 == mine, 1= 1 mine nearby, 2 = 2 mines nearby ...
	//Randomly assigns the tiles in a 2d grid a value of bomb or not.	
	public Mines(int row, int column){

		//creates a minesweeper board 20x20
		tiles = new Tile[row][column];

		for(int r = 0;r<row;r++){

			for(int c = 0;c<column;c++){
				//Randomly assigns tile as mine or not mine
				int ran = ((int)(Math.random() * 4 + 1));
				if(ran == 1){
					tiles[r][c] = new Tile(true,true,9);
				}
				else{
					tiles[r][c] = new Tile(true,false,0);
				}
			}
		}


	}
	public boolean isNextTo(int a, int b, int a2, int b2){
		boolean next= false;
		if (a== a2 && b== b2+1){
			next= true;
		}
		else if (a== a2 && b== b2-1){
			next= true;
		}
		else if (a== a2+1 && b== b2-1){
			next= true;
		}
		else if (a== a2+1 && b== b2){
			next= true;
		}
		else if (a== a2+1 && b== b2+1){
			next= true;
		}
		else if (a== a2-1 && b== b2-1){
			next= true;
		}
		else if (a== a2-1 && b== b2){
			next= true;
		}
		else if (a== a2-1 && b== b2+1){
			next= true;
		}
		return next;
	}
	// how to format input: a,b =tiles[row][col].
	// returns int of how many bombs around
	public int getBombs(int rowa, int cola){
		int counter=0;
		for (int row= 0; row<tiles.length; row++){
			for(int col=0; col<tiles[row].length; col++){
				if (isNextTo(rowa, cola, row, col)){
					if (!(tiles[row][col].getIsMine())){
					counter++;
					}
				}
			}
		}
		return counter;
		
		
	}
	// get bombs is done now.
	
	//Prints minefield of bomb status 
	public void printMineField(){
		for(int r = 0;r<tiles.length;r++){

			for(int c = 0;c<tiles[0].length;c++){

				System.out.print(tiles[r][c].getIsMine() + " ");
				if (tiles[r][c].getIsMine()) {
					System.out.print(" ");
				}

			}
			System.out.println();
		}


	}
	
	
	public Tile select(int r, int c){
		this.tiles[r][c].show();
		if(tiles[r][c].getIsMine()){
			boom(tiles[r][c]);
		}
		
		return tiles[r][c];
		
	}
	
	
	
	// Sets off all bombs. It is called each time bomb is selected 
	public void boom(Tile ne){
		int off = 0;
		
		if(ne.getIsMine()){
		for(int r = 0;r<tiles.length;r++){
			for(int c = 0;c<tiles.length;c++){
				if(tiles[r][c].getIsMine()){
					tiles[r][c].show();
				}
				
				
			}
		}
		}
	}
//g5y3rqufweahasuh
// WORK!
}
