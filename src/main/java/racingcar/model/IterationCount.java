package racingcar.model;

public class IterationCount {
    private final int iterationCount;

    public IterationCount(String iterationCount) {
        if (!isNumber(iterationCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }

        if (!isValidRange(iterationCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
        this.iterationCount = Integer.parseInt(iterationCount);
    }

    private boolean isNumber(String count) {
        return count.chars().allMatch(Character::isDigit);
    }

    private boolean isValidRange(String count) {
        return Integer.parseInt(count) >= 1;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
