package racingcar;

import java.util.List;

public interface View {
    void moveResult(List<Boolean> movements);

    int inputMoveCount();
}
