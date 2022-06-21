package racingcar;

import java.util.List;

public interface View {
    
    List<String> inputCarNames();

    int inputMoveTimes();

    void raceResult(RaceResult raceResult);
}
