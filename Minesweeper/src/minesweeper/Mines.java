package minesweeper;

//The 2d grid of
public class Mines {

	private Tile[][] tiles;
	//public Tile(boolean h, boolean m, int n){
	//0 = open 9 == mine, 1= 1 mine nearby, 2 = 2 mines nearby ...
	//Randomly assigns the tiles in a 2d grid a value of bomb or not.	
	public Mines(){

		//creates a minesweeper board 20x20
		tiles = new Tile[20][20];

		for(int r = 0;r<20;r++){

			for(int c = 0;c<20;c++){
				//Randomly assigns tile as mine or not mine
				int ran = ((int)(Math.random() * 4 + 1));
				if(ran == 1){
					tiles[r][c] = new Tile(true,false,9);
				}
				else{
					tiles[r][c] = new Tile(true,true,0);
				}
			}
		}


	}
	//Prints minefield of bomb status 
	public void printMineField(){

		for(int r = 0;r<20;r++){

			for(int c = 0;c<20;c++){

				System.out.print(tiles[r][c].getIsMine() + "\t");

			}
			System.out.println();
		}


	}


}
