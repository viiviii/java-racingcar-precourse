package racingcar.gamePlay;

import java.util.List;

public interface CarFactory<T> {

    List<T> create(List<String> carNames);
}
