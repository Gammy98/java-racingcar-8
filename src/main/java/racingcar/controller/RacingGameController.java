package racingcar.controller;

import org.junit.platform.commons.function.Try;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final OutputView outputView;

    public RacingGameController(){
        this.outputView = new OutputView();
    }

    public void play(){
        playGame();
    }

    private void playGame(){
        Cars cars = getCarsFromUser();
        TryCount tryCount = getTryCountFromUser();

        runRace(cars, tryCount);

        List<String> winners = cars.findWinners();
        outputView.printWinners(winners);
    }

    private void runRace(Cars cars, TryCount tryCount) {
        outputView.printExecutionResultHeader();

        //모든 차 이동 후 결과 출력
        for (int i = 0; i < tryCount.getCount(); i++) {
            cars.moveAll();
            outputView.printRoundResult(cars);
        }
    }

    private Cars getCarsFromUser(){
        String carNameInput = InputView.readCarName();
        return new Cars(carNameInput);
    }

    private TryCount getTryCountFromUser(){
        String tryCountInput = InputView.readTryCount();
        return new TryCount(tryCountInput);
    }
}

