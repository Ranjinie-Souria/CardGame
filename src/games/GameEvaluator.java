package games;

import java.util.List;

import model.IPlayer;
import model.PlayingCard;

public interface GameEvaluator {
    public IPlayer evaluateWinner(List<IPlayer> players);
}
    

