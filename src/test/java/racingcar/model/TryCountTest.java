package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryCountTest {

    @Test
    @DisplayName("숫자시도 성공적으로 생성!")
    void create_trycount_success(){
        String input = "2";
        TryCount  tryCount = new TryCount(input);
        assertThat(tryCount.getCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "", "pobi"})
    @DisplayName("입력이 숫자가 아닐 경우 예외를 발생시킨다.")
    void create_trycount_fail_notnumber(String invalidInput) {

        assertThatThrownBy(() -> new TryCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 시도 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("입력이 1 미만의 숫자일 경우 예외를 발생시킨다.")
    void create_trycount_fail_underone(String invalidInput) {

        assertThatThrownBy(() -> new TryCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 시도 횟수는 1 이상이어야 합니다.");
    }

}
