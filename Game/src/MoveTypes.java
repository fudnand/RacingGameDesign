import java.util.*;
abstract class MoveType{	
	
 	abstract int moveBy(int dieThrow, int playerPos, Positioning handler);
 	
	
	public String toString(){
		return " ";
	}
 	public String toString(int move){
 		return ("This is move-"+ move);
 	}
 }

class MoveOne extends MoveType{
	int changePosition;
	int move =1;
	public int moveBy(int dieThrow, int playerPos, Positioning handler) {
		changePosition = (dieThrow + (playerPos - handler.getTrailer()))/2;
		
		if(dieThrow<2){
			return (-1 * changePosition);
		}		
		return changePosition;
	}
	
	public String toString(){
		return super.toString(move);
	}
}

class MoveTwo  extends MoveType{
	int changePosition;
	int move = 2;
	
	public int moveBy(int dieThrow, int playerPos, Positioning handler) {
		if(dieThrow%2 ==0){
			changePosition = (3*dieThrow);
			return changePosition;				
		}
		return dieThrow;
	}
	
	public String toString(){
		return super.toString(move);
	}
}

class MoveThree  extends MoveType{
	int changePosition;
	int move = 3;
	
	public int moveBy(int dieThrow, int playerPos, Positioning handler) {
		
			changePosition = (playerPos - handler.getTrailer())/2;
		if(dieThrow<3){
			return changePosition;				
		}
		return (-1*changePosition);
	}
	
	public String toString(){
		return super.toString(move);
	}
}

class Resposnes{
	public static MoveType getResponse(){
		Random rand = new Random();
		int respondWith = 1 + rand.nextInt( 3 );
		MoveType respond = null;
		switch( respondWith ){
		case 1: respond = new MoveOne(); 
				break;
		case 2: respond = new MoveTwo();
				break;
		case 3: respond = new MoveThree();	
		}
		return respond;		
	}
}