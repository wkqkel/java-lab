package baseball.controller;

import baseball.model.PlayResult;
import baseball.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public PlayResult handleInput(String playerInput) {
        return gameService.play(playerInput);
    }

    public boolean handleRestart(String playerInput) {
        if ("1".equals(playerInput)) {
            gameService.restart();
            return true;
        }

        return false;
    }
}
