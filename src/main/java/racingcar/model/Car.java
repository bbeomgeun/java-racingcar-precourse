package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;
    private static final int START_NUMBER_RANGE = 0;
    private static final int END_NUMBER_RANGE = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        isValidInput(name);
        this.name = name;
    }

    private void isValidInput(String name) {
        isValidSize(name);
        isBlankString(name);
    }

    private void isValidSize(String name) {
        if (name.length() > MAX_NAME_SIZE || name.length() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private void isBlankString(String name) {
        if (name.chars().allMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("[ERROR] 이름이 공백이면 안됩니다.");
        }
    }

    public void moveForward() {
        if (isMovingCondition()) {
            this.position++;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
