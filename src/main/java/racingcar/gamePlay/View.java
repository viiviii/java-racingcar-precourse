package racingcar.gamePlay;

import java.util.List;

public interface View {

    List<String> inputCarNames();

    int inputAttemptCount();

    void outputMoveState(String name, Car.State state);
}
