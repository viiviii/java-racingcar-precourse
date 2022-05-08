package racingcar.game;

import racingcar.race.*;
import racingcar.rule.MoveCount;
import racingcar.rule.Name;
import racingcar.rule.NameDelimiter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarsFactory racingCarsFactory;
    private final NameDelimiter nameDelimiter;
    private final WinnersReferee winnersReferee;

    public Game(InputView inputView, OutputView outputView, RacingCarsFactory racingCarsFactory, NameDelimiter nameDelimiter, WinnersReferee winners) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarsFactory = racingCarsFactory;
        this.nameDelimiter = nameDelimiter;
        this.winnersReferee = winners;
    }

    public void play() {
        final RacingCars racingCars = createRacingCars();
        final MoveCount moveCount = createMoveCount();
        final List<MoveRecords> result = startRaceWith(racingCars, moveCount);
        outputView.printResult(result);
        final Winners winners = winnersReferee.determineFrom(result.get(result.size() - 1)); // TODO
        outputView.printWinners(winners);
    }

    RacingCars createRacingCars() {
        try {
            final String inputNames = inputView.inputCarsNames();
            final List<Name> delimitedNames = nameDelimiter.delimit(inputNames);
            return racingCarsFactory.create(delimitedNames);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createRacingCars();
        }
    }

    MoveCount createMoveCount() {
        try {
            final String inputMoveCount = inputView.inputMoveCount();
            return MoveCount.fromString(inputMoveCount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createMoveCount();
        }
    }

    List<MoveRecords> startRaceWith(RacingCars racingCars, MoveCount moveCount) {
        final List<MoveRecords> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final MoveRecords moveRecords = racingCars.move();
            result.add(moveRecords);
        }
        return result;
    }
}
