
public class driver {

	public static void main(String[] args) {
		handler gamer = new handler(5);
		for(int i = 0; i < 5; i++) 
			gamer.addPlayer();
		gamer.playGame();
		
		gamer.standings();

	}

}
