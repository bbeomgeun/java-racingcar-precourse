package racingcar.model;

public class IterationCount {
    private final int iterationCount;

    public IterationCount(String iterationCount) {
        isValidCount(iterationCount);
        this.iterationCount = Integer.parseInt(iterationCount);
    }

    private void isValidCount(String count) {
        isNumber(count);
        isValidRange(count);
    }

    private void isNumber(String count) {
        if (!count.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    private void isValidRange(String count) {
        if (Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
