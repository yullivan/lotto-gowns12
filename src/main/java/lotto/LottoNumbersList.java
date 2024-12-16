package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    public LottoNumbersList(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public LottoNumbersList(Count count) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>(List.of());

        for (int i = 0; i < count.getNon_autoCount(); i++) {
            lottoNumbersList.add(Input.non_autoLottoNumberInput());
        }

        for (int i = 0; i < count.getAutoCount(); i++) {
            lottoNumbersList.add(new LottoNumbers());
        }

        if (lottoNumbersList.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 로또번호가 한개도 선택되지 않았습니다.");
        }

        this.lottoNumbersList = lottoNumbersList;
    }


    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public List<Rank> rankList(LottoNumbers WinningLottoNumbers, LottoNumber BonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            ranks.add(lottoNumbers.matchCount(WinningLottoNumbers, BonusNumber));
        }

        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbersList that = (LottoNumbersList) o;
        return Objects.equals(lottoNumbersList, that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbersList);
    }
}
