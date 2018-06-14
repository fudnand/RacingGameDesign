import java.util.*;

public class Player {
	int position;
	int playerNum;
	Random rand;
	MoveType movetype;
	int response;
	Positioning play;
	
	
	public Player(int playerNum, Positioning play){
		position = 0;
		this.playerNum = playerNum;
		rand = new Random();
		this.play = play;
		resetResponse();
		
	}
	
	public int getPosition(){
		return position;
	}
	
	public void resetResponse(){
		movetype = Resposnes.getResponse();
		response = 1 + rand.nextInt(4);
	}
	
	public void makeMove(){
		int dieThrow = 1 + rand.nextInt(6);
		if( response > 0 ){
			position += movetype.moveBy(dieThrow, position, play); 
			response--;
		}
		else resetResponse();
	}
	
	public String toString(){
		return "Player: " + (playerNum+1) + " is in: " + position + " "+ movetype.toString();
	}
}
