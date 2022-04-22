package racingcar.model;

public enum Move {
    FORWARD, STOP;

    public boolean isForward() {
        return this == FORWARD;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
