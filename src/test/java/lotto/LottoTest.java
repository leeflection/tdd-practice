package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @Test
    @DisplayName("중복 발생 시 [ERROR]로 시작하는 에러 메시지를 출력한다.")
    public void printErrorMessageCauseDuplicationNumber(){
        List list = List.of(1,1,2,3,4,5);
        String msg = "[ERROR]";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(()-> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(msg).isEqualTo(out.toString().substring(0,7));
    }
}
