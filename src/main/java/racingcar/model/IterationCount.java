package racingcar.model;

public class IterationCount {
    private final int iterationCount;

    public IterationCount(String iterationCount) {
        if (isValidCount(iterationCount)) {
            this.iterationCount = Integer.parseInt(iterationCount);
        } else{
            this.iterationCount = 0;
        }
    }

    private boolean isValidCount(String count) {
        return isNumber(count) && isValidRange(count);
    }

    private boolean isNumber(String count) {
        if (count.chars().allMatch(Character::isDigit)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    private boolean isValidRange(String count) {
        if (Integer.parseInt(count) >= 1) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
