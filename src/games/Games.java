package games;

import controller.GameController;
import model.Deck;
import model.DeckFactory;
import model.DeckFactory.DeckType;
import view.CommandLineView;
import view.GameSwingPassiveView;
import view.GameSwingView;
import view.GameViewables;

public class Games {
	
	public static void main(String args[]) {
GameViewables views = new GameViewables();
		
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		views.addViewable(gsv);
		
		for(int i = 0; i< 3; i++) {
			GameSwingPassiveView passiveView = new GameSwingPassiveView();
			passiveView.createAndShowGUI();
			
			views.addViewable(passiveView);
			
			// sleep to move new Swing frame on window
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), views, new HighCardGameEvaluator());

		gc.run();
	}
}