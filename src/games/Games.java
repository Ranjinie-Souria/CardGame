package games;

import controller.GameController;
import model.Deck;
import view.CommandLineView;
import view.GameSwingView;

public class Games {
	
	public static void main(String args[]) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		
		GameController gc = new GameController(new Deck(), gsv, new HighCardGameEvaluator());
		
		gc.run();
	}
}