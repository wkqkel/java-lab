package baseball;

import baseball.controller.GameController;
import baseball.model.PlayResult;
import baseball.service.GameService;
import baseball.view.GameView;

public class Application {

    public static void main(String[] args) {

        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        GameView.start();

        while (true) {
            String playerInput = GameView.getPlayerInput();
            PlayResult result = gameController.handleInput(playerInput);
            GameView.displayResult(result);

            if (!result.isEnd()) {
                continue;
            }

            GameView.end();

            if (!gameController.handleRestart(GameView.restart())) {
                break;
            }
        }

    }
}
