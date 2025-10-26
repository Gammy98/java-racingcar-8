package racingcar.model;

public class TryCount {

    private static final String ERROR_MESSAGE = "ERROR : ";
    private static final int MIN_TRYCOUNT = 1;
    private final int count ;

    public TryCount(String input){
        int parsedCount = validateNumber(input);
        validateRange(parsedCount);
        this.count = parsedCount;
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateRange(int count) {
        if (count < MIN_TRYCOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getCount(){
        return count;
    }
}

