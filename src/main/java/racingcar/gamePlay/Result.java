package racingcar.gamePlay;

public interface Result {

    int attemptCount();

    Record firstRecord();

    Record lastRecord();

    Iterable<Record> allRecords();
}
