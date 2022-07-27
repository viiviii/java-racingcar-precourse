package racingcar.gamePlay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountTest {

    @DisplayName("더 시도할 수 있다")
    @Test
    void hasNextReturnTrue() {
        //given
        int onceAttempts = 1;

        //when
        AttemptCount attemptCount = new AttemptCount(onceAttempts);
        boolean actual = attemptCount.hasNext();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("더 시도할 수 없다")
    @Test
    void hasNextReturnFalse() {
        //given
        int noAttempts = 0;

        //when
        AttemptCount attemptCount = new AttemptCount(noAttempts);
        boolean actual = attemptCount.hasNext();

        //then
        assertThat(actual).isFalse();
    }

    @DisplayName("다음 시도 순서를 반환한다")
    @Test
    void move() {
        //given
        int onceAttempts = 1;

        //when
        AttemptCount attemptCount = new AttemptCount(onceAttempts);
        int next = attemptCount.next();

        //then
        assertThat(next).isOne();
    }

    @DisplayName("다음 시도 순서가 없으면 예외를 던진다")
    @Test
    void unableToMove() {
        //given
        int noAttempts = 0;

        //when
        AttemptCount attemptCount = new AttemptCount(noAttempts);

        //then
        assertThatThrownBy(() -> attemptCount.next())
                .isInstanceOf(NoSuchElementException.class);
    }
}