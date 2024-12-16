package lotto;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationTests {
    @Test
    public void testInvalidPriceTooLow() {
        // 1000 미만의 가격을 입력하면 예외가 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchasePrice(500);
        });
    }

    @Test
    public void testInvalidPriceNotMultipleOfThousand() {
        // 천원 단위가 아닌 가격을 입력하면 예외가 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchasePrice(1500);
        });
    }

    @Test
    void non_autoLottoNumberInputTest() {
        String given = "1,2,3,,4,5";
        String given2 = "1.2.3.4.5.6";
        String given3 = "a,s,d,f,g,h";
        String given4 = "1,2,3,4,5,6";


        assertThrows(IllegalArgumentException.class, () -> {
            String s = non_autoLottoNumberInput(given);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            String s = non_autoLottoNumberInput(given2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            String s = non_autoLottoNumberInput(given3);
        });

        Assertions.assertThat(non_autoLottoNumberInput(given4)).isEqualTo(given4);
    }

    private String non_autoLottoNumberInput(String given) {
        String non_autoLottoNumberInput;
        String regex = "^(\\d{1,2})(,(\\d{1,2})){5}$";

        non_autoLottoNumberInput = given;
        if (!non_autoLottoNumberInput.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식을 지켜주세요.[번호1,번호2,번호3,번호4,번호5,번호6]");
        }
        return given;
    }

    @Test
    void winningCheckTest() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);


        LottoNumbers givenLottoNumbers1 = new LottoNumbers(List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumbers givenLottoNumbers2 = new LottoNumbers(List.of(new LottoNumber(43), lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumbers givenLottoNumbers3 = new LottoNumbers(List.of(new LottoNumber(10), lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumbers givenLottoNumbers4 = new LottoNumbers(List.of(new LottoNumber(10), new LottoNumber(20), lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumbers givenLottoNumbers5 = new LottoNumbers(List.of(new LottoNumber(10), new LottoNumber(20), new LottoNumber(30), lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumbers givenLottoNumbers6 = new LottoNumbers(List.of(new LottoNumber(10), new LottoNumber(20), new LottoNumber(30), new LottoNumber(40), lottoNumber5, lottoNumber6));
        LottoNumbersList givenlottoNumbersList = new LottoNumbersList(List.of(givenLottoNumbers1,givenLottoNumbers2,givenLottoNumbers3,givenLottoNumbers4,givenLottoNumbers5,givenLottoNumbers6));

        LottoNumbers givenWinningLottoNumbers = new LottoNumbers(List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6));
        LottoNumber givenBonusNumber = new LottoNumber(43);

        List<Rank> want = List.of(Rank.First,Rank.SECOND,Rank.THIRD,Rank.FOURTH,Rank.FIFTH,Rank.Miss);
        List<Rank> result = givenlottoNumbersList.rankList(givenWinningLottoNumbers,givenBonusNumber);

        Assertions.assertThat(result).isEqualTo(want);
    }


}

