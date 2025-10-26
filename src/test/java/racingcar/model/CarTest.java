package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("성공적으로 생성")
    void create_car_success(){
        String validName = "pobi";

        assertThatCode(() -> new Car(validName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과했습니다")
    void create_car_fail_exceed5(){
        String longName = "pobipobi";

        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("자동차 이름이 비어있거나 공백입니다")
    void create_car_fail_isblank(String blankName) {
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 자동차 이름은 비어 있을 수 없습니다.");
    }
}
