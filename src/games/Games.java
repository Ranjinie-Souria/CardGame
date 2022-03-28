package games;

import controller.GameController;
import model.Deck;
import model.DeckFactory;
import model.DeckFactory.DeckType;
import view.CommandLineView;
import view.GameSwingView;

public class Games {
	
	public static void main(String args[]) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), gsv, new HighCardGameEvaluator());

		gc.run();
	}
}