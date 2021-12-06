package racingcar;

import racingcar.controller.GameController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new OutputView());
        gameController.run();
    }
}
