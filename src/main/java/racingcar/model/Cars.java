package racingcar.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(String carStr) {
        this.carList = Arrays.stream(carStr.split(",")).map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAllCar() {
        carList.forEach(Car::movingForward);
    }

    private int getFinalMaxPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getFinalPosition);
        Optional<Car> winner = carList.stream().max(comparatorByPosition);
        return winner.get().getFinalPosition();
    }

    public List<Car> getWinners() {
        int winnerPosition = getFinalMaxPosition();
        return carList.stream().filter(v -> v.getFinalPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
