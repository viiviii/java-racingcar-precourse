package racingcar.gamePlay;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: 클래스명
public final class AttemptCount implements Iterator<Integer> {
    private final int count;
    private int currentIndex;

    public AttemptCount(int count) {
        validateMinimum(count);
        this.count = count;
    }

    private void validateMinimum(int count) {
        final int MIN = 0;
        if (count < MIN) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < count;
    }


    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        increaseIndex();
        return currentIndex;
    }

    private void increaseIndex() {
        currentIndex += 1;
    }
}
