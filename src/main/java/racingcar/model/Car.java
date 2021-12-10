package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;
    private static final int START_NUMBER_RANGE = 0;
    private static final int END_NUMBER_RANGE = 9;
    private static final String NAME_ERROR_MESSAGE = "[ERROR] 자동차의 이름은 1자 이상 5자 이하만 가능합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        if (!isValidInput(name)) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        this.name = name;
    } // TODO : 상위에서 Try catch로 받아주기

    private boolean isValidInput(String name) {
        return isValidSize(name);
    }

    private boolean isValidSize(String name) {
        return name.length() <= MAX_NAME_SIZE && name.length() >= MIN_NAME_SIZE;
    }

    public void moveForward() {
        if (isMovingCondition()) {
            this.position++;
        }
    }

    public boolean isMoving() {
        return isMovingCondition();
    }

    private boolean isMovingCondition() {
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE) >= 4;
    }

    public int getFinalPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
