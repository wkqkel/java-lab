package baseball.controller;

import baseball.model.PlayResult;
import baseball.service.GameService;
import baseball.utils.Validator;

public class GameController {

    public static final String RESTART_COMMAND = "1";

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public PlayResult handleInput(String playerInput) {
        validatePlayerInput(playerInput);

        return gameService.play(playerInput);
    }

    public boolean handleRestart(String playerInput) {
        if (RESTART_COMMAND.equals(playerInput)) {
            gameService.restart();
            return true;
        }

        return false;
    }

    private void validatePlayerInput(String playerInput) {
        if (playerInput == null || playerInput.isBlank()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }

        if (!Validator.isNumeric(playerInput)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}