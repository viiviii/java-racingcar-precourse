package racingcar.gamePlay;

public interface Car {

    String name();

    State state();

    void move();

    interface State {
        int forwardCount();
    }
}
