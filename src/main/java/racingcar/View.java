package racingcar;

import java.util.List;

public interface View {

    List<String> inputCarNames();

    int inputAttemptCount();

    void raceResult(RaceResult raceResult);
}
