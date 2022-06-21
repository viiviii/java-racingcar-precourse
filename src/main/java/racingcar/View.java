package racingcar;

import java.util.List;

public interface View {
    void moveResult(List<Position> positions);

    int inputMoveTimes();
}
