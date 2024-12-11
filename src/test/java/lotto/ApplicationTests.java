package lotto;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class ApplicationTests {
    @Test
    void name() {
        List<Integer> numberList = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> numberList2 = new ArrayList<>(List.of(1,2,3,4,5,7));;
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numberList2);
        List<LottoNumbers> lottoNumbersList = List.of(lottoNumbers);


        Assertions.assertThat(Util.rankList(lottoNumbersList,lottoNumbers2,7).get(0)).isEqualTo(Rank.SECOND);
    }

    @Test
    void nonAutoInput() {
        LottoNumbers lottoNumbers = new LottoNumbers(1,2,3,4,5,6);
        List<LottoNumbers> lottoNumbers1 = new ArrayList<>();
        lottoNumbers1 = Util.lottoNumbersList(1);

        Assertions.assertThat(lottoNumbers1.get(0).equals(lottoNumbers)).isTrue();
    }
}
