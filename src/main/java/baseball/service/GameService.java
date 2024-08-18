package baseball.service;

import baseball.model.Game;
import baseball.model.PlayResult;

public class GameService {

    private Game game;

    public GameService() {
        this.game = new Game();
    }

    public PlayResult play(String playerInput) {
        return game.play(playerInput);
    }

    public void restart() {
        this.game = new Game();
    }
}
