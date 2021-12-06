package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";
    private static final String PROGRESS_BAR = "-";
    private static final String NEW_LINE = "\n";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printRequestMessage() {
        System.out.println(REQUEST_COUNT_MESSAGE);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printProgress(Cars carList) {
        System.out.println(RESULT_MESSAGE);
        List<Car> currentCars = carList.getCurrentCars();

        for (Car car : currentCars) {
            System.out.print(car.getName() + " : " );
            StringBuilder carProgressBar = new StringBuilder();
            for (int i = 0; i < car.getFinalPosition(); i++) {
                carProgressBar.append(PROGRESS_BAR);
            }
            System.out.println(carProgressBar.toString()+NEW_LINE);
        }
    }

    public void printFinalWinners(List<String> winners) {
        System.out.println(FINAL_WINNER_MESSAGE+String.join(DELIMITER, winners));
    }
}
