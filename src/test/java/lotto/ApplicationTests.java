package lotto;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationTests {
    @Test
    void lottonumber() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber lottoNumber = new LottoNumber(46);
        });
        assertEquals("잘못된 숫자", exception.getMessage());
    }

    @Test
    void Lottonumbers() {
        LottoNumber lottoNumber = new LottoNumber(45);
        LottoNumber lottoNumber2 = new LottoNumber(12);
        LottoNumber lottoNumber3 = new LottoNumber(15);
        LottoNumber lottoNumber4 = new LottoNumber(28);
        LottoNumber lottoNumber5 = new LottoNumber(36);
        LottoNumber lottoNumber6 = new LottoNumber(36);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6);
        });
        assertEquals("중복 숫자", exception.getMessage());
    }

    @Test
    void numbersList() {

        Assertions.assertThat(new LottoNumbersList(true,2).getLottoNumbersList().size()).isEqualTo(2);
    }
}

