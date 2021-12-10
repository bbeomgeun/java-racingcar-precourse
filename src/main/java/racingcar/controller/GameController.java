package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.IterationCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private IterationCount iterationCount;
    private Cars cars;

    public void run() {
        inputNameStr();
        inputCount();
        gameProgress();
    }

    private void inputNameStr() {
        while (true) {
            try {
                OutputView.printStartMessage();
                cars = new Cars(InputView.input());
                return;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
    }

    private void inputCount() {
        while (true) {
            try {
                OutputView.printRequestMessage();
                iterationCount = new IterationCount(InputView.input());
                return;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
    }

    private void gameProgress() {
        OutputView.printResultMessage();
        for (int gameCount = 0; gameCount < iterationCount.getIterationCount(); gameCount++) {
            cars.moveAllCar();
            OutputView.printProgress(cars);
        }
        OutputView.printFinalWinners(cars.getWinnersName());
    }
}
