package games;

import java.util.List;

import model.Player;
import model.PlayingCard;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
}
    

