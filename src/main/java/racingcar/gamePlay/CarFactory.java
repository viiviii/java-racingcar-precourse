package racingcar.gamePlay;

import java.util.List;

public interface CarFactory {

    List<Car> createCars(List<String> carNames);
}
