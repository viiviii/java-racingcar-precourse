package racingcar.gamePlay;

public interface Record {

    Iterable<String> carNames();

    int positionBy(String carName);
}
