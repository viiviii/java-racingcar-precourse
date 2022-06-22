package racingcar.gamePlay;

import java.util.List;

public interface CarFactory {

    Cars createCars(List<String> carNames);
}
