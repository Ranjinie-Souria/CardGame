package controller;

import java.util.ArrayList;
import java.util.List;

import games.GameEvaluator;
import model.Deck;
import model.Player;
import model.PlayingCard;
import view.View;


public class GameController {

	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}

	Deck deck;
	List<Player> players;
	Player winner;
	View view;
	GameState gameState;
	GameEvaluator evaluator;

	public GameController(Deck deck, View view, GameEvaluator gameEvaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		this.evaluator = gameEvaluator;
		view.setController(this);
	}

	public void run() {
		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}

		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}

	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}

	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for (Player player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}

	public void flipCards() {
		int playerIndex = 1;
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), 
					pc.getRank().toString(), pc.getSuit().toString());
		}

		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}

	void evaluateWinner() {
		winner = evaluator.evaluateWinner(players);
	}

	void displayWinner() {
		view.showWinner(winner.getName());
	}

	void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}

}