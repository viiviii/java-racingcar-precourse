package racingcar.gamePlay;

public enum Movement {
    FORWARD, STOP;

    public boolean isForward() {
        return this == FORWARD;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
