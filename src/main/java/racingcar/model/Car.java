package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE = "ERROR : " ;
    private static final int MOVE_FORWARD_BOUNDARY = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String name;
    private int position = 0;

    public Car(String name){
        validateName(name);
        this.name = name ;
    }

    private void validateName(String name) {
        if (isNameBlank(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "자동차 이름은 비어 있을 수 없습니다.");
        }
        if (isNameTooLong(name)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isNameBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    private boolean isNameTooLong(String name) {
        return name.trim().length() > MAX_NAME_LENGTH;
    }

    //test용이다 (random사용 x)
    void move(int number) {
        if (number >= MOVE_FORWARD_BOUNDARY) {
            this.position++;
        }
    }

    //실제 구현에 사용되는 코드
    public void move(){
        int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        move(randomNum);
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }
}

