package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(String carStr) {
        List<Car> carList = Arrays.stream(carStr.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        isValidCars(carList);
        this.carList = carList;
    }

    private void isValidCars(List<Car> carList) {
        long count = carList.stream()
                .distinct()
                .count();
        if (count != carList.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복되면 안됩니다.");
        }
    }

    public void moveAllCar() {
        carList.forEach(Car::moveForward);
    }

    public List<String> getWinnersName() {
        int winnerPosition = getFinalMaxPosition();
        return carList.stream()
                .filter(car -> car.getFinalPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getFinalMaxPosition() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getFinalPosition))
                .orElseThrow(NoSuchElementException::new)
                .getFinalPosition();
    }

    public List<Car> getCurrentCars() {
        return Collections.unmodifiableList(this.carList);
    }
}
