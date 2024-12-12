package lotto;

import java.util.*;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    //자동 수동 여부와 개수에 맞춰 로또번호 리스트 생성
    public LottoNumbersList(boolean auto, int purchasePrice, int nonAutoCount) {
        int count = purchasePrice / 1000 - nonAutoCount;
        if (auto) {
            this.lottoNumbersList = NumberCreate.autoNumbersCreate(count);

        } else {
            this.lottoNumbersList = NumberCreate.nonAutoNumbersCreate(nonAutoCount);
        }
    }


    public LottoNumbersList(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }


    public List<LottoNumbers> getLottoNumbersList() {
            return lottoNumbersList;
        }

    //로또 리스트끼리 병합

    public LottoNumbersList mergeLottoNumbersList(LottoNumbersList other) {
        List<LottoNumbers> temp = new ArrayList<>(lottoNumbersList);
        temp.addAll(other.getLottoNumbersList());
        return new LottoNumbersList(temp);
    }

    //로또번호끼리 비교
    public List<Rank> rankList(LottoNumbers winningList, int bonusNumber) {
        ArrayList<Rank> rankList = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            rankList.add(Rank.valueOf(lottoNumbers.matchCount(winningList), lottoNumbers.matchBonus(bonusNumber)));
        }

        return rankList;
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
