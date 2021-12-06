package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.IterationCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private IterationCount iterationCount;
    private Cars cars;

    public GameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        inputNameStr();
        inputCount();
        gameProgress();
    }

    private void inputNameStr() {
        boolean validFlag;
        while (true) {
            try {
                validFlag = true;
                OutputView.printStartMessage();
                cars = new Cars(InputView.input());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
                validFlag = false;
            }
            if (validFlag) {
                return;
            }
        }
    }

    private void inputCount() {
        boolean validFlag = true;
        while (true) {
            try {
                validFlag = true;
                OutputView.printRequestMessage();
                iterationCount = new IterationCount(InputView.input());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
                validFlag = false;
            }
            if (validFlag) {
                return;
            }
        }
    }

    private void gameProgress() {
        OutputView.printResultMessage();
        for (int gameCount = 0; gameCount < iterationCount.getIterationCount(); gameCount++) {
            cars.moveAllCar();
            outputView.printProgress(cars);
        }
        outputView.printFinalWinners(cars.getWinnersName());
    }
}
