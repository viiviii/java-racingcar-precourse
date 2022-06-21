package racingcar.gamePlay;

public interface RaceResult {
    int attemptCount();

    Record recordOf(int attemptIndex);
}
