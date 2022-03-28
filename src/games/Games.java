package games;

import controller.GameController;
import model.Deck;
import view.CommandLineView;

public class Games {
	
	public static void main(String args[]) {
		GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
		gc.run();
	}
}