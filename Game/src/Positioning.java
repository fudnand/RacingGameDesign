interface Positioning {
	int getLeader();
	int getTrailer();
	void playGame();
}

class handler implements Positioning{
	Player[] players;
	int numPlayer;
	final int WIN = 50;
	int won = 1; //assumes at least one player playing
	
	public handler(int numPlaying){
		players = new Player[numPlaying];
		numPlayer = 0;
	}
	
	public void addPlayer(){
		players[numPlayer] = new Player(numPlayer, this);
		numPlayer++;
	}
	
	@Override
	public int getLeader() {
		int pos  = players[0].position;
		for(int i = 1; i < numPlayer; i++){
			if(players[i].position > pos ) 
				pos  = players[i].position;
		}
		return pos; 
	}

	@Override
	public int getTrailer() {
		int pos = players[0].position;
		for(int i = 1; i < numPlayer; i++){
			if(players[i].position < pos) 
				pos  = players[i].position;
		}
		return pos ; 
	}
	
	public void playGame(){
		int round = 1;
		int playerToPlay = 0;
		System.out.println("\nRound-" + round);
		while( !winner() ){
			players[playerToPlay].makeMove();
			System.out.println( players[playerToPlay].toString() );
			playerToPlay++;
			if( playerToPlay > numPlayer - 1 ){ 
				round++;
				System.out.println("\nRound-" + round);
				playerToPlay = 0;
			}
		}	
	}
	
	private boolean winner(){
		for(int i = 1; i < numPlayer; i++){
			if(players[i].position >= WIN){
				won = i+1;
				return true;
			}
		}
		return false;
	}	
	public int whoWon(){
		return won;
	}
	
	public void standings(){
		System.out.println("\n********************************************");
		System.out.println("\t\tStandings");
		System.out.println("********************************************");
		System.out.print("Player: \t");
		for(int i=0; i<players.length; i++){
			System.out.print((i+1)+"\t");
		}
		System.out.print("\nPosition: \t");
		for(int i=0; i<players.length; i++){
			System.out.print(players[i].getPosition()+"\t");
		}
		System.out.println("\n\nPlayer-"+ whoWon()+ " won the game");
	}
	
}