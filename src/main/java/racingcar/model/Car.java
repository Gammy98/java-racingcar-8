package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE = "ERROR : " ;
    private final String name;

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
}

