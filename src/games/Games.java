package games;

import controller.GameController;
import model.Deck;
import view.View;

public class Games {
	
	public static void main(String args[]) {
		GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
		gc.run();
	}
}