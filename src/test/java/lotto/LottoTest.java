package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("중복 발생 시 IllegalArgumentException이 발생한다.")
    public void validateDuplicationNumber(){
        List list = List.of(1,1,2,3,4,5);

        assertThatThrownBy(()-> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
