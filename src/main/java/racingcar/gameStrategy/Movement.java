package racingcar.gameStrategy;

enum Movement {
    FORWARD, STOP;

    public boolean isForward() {
        return this == FORWARD;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
