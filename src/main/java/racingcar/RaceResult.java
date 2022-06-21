package racingcar;

public interface RaceResult {
    int attemptCount();

    Record recordOf(int attemptIndex);
}
