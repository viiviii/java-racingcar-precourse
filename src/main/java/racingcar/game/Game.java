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
    private final CarFactory carFactory;
    private final NameDelimiter nameDelimiter;

    public Game(InputView inputView, OutputView outputView, CarFactory carFactory, NameDelimiter nameDelimiter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
        this.nameDelimiter = nameDelimiter;
    }

    public void play() {
        final RacingCars racingCars = createRacingCars();
        final MoveCount moveCount = createMoveCount();
        final List<MoveRecords> result = startRaceWith(racingCars, moveCount);
        outputView.printResult(result);
        final WinnersDto winners = determineWinners(result.get(result.size() - 1)); // TODO
        outputView.printWinners(winners);
    }

    RacingCars createRacingCars() {
        try {
            final String inputNames = inputView.inputCarsNames();
            final List<Name> delimitNames = nameDelimiter.delimit(inputNames);
            final List<Car> cars = carFactory.create(delimitNames);
            return RacingCars.from(cars);
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

    public WinnersDto determineWinners(MoveRecords moveRecords) {
        final WinnersReferee winners = new WinnersReferee();
        final List<Name> winnerNames = winners.determineFrom(moveRecords);
        return WinnersDto.from(winnerNames);
    }
}
