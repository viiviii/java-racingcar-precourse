package racingcar.gamePlay;

import java.util.Set;

public interface Record {
    
    Set<String> carNames();

    int positionBy(String carName);
}
