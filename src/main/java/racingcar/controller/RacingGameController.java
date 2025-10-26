package racingcar.controller;

import org.junit.platform.commons.function.Try;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;

public class RacingGameController {

    public void play(){
        try {
            playGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playGame(){
        Cars cars = getCarsFromUser();
        TryCount tryCount = getTryCountFromUser();

        //TODO : 게임 로직 구현
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

