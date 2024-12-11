package lotto;

import java.util.*;
public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    //자동 수동 여부와 개수에 맞춰 로또번호 리스트 생성
    public LottoNumbersList(boolean auto, int count) {
        ArrayList<LottoNumbers> temp = new ArrayList<>();
        if (auto) {
            for (int i = 0; i < count; i++) {
                temp.add(new LottoNumbers(auto));
            }
            this.lottoNumbersList = temp;
        } else {
            for (int i = 0; i < count; i++) {
                temp.add(new LottoNumbers(auto));
                if (i < count - 1) {
                    System.out.println("다음 번호를 입력하세요.");
                }
            }
            this.lottoNumbersList = temp;
        }
    }


    public LottoNumbersList(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    //로또 리스트끼리 병합
    public LottoNumbersList mergeLottoNumbersList(LottoNumbersList other) {
        ArrayList<LottoNumbers> temp = new ArrayList<>(lottoNumbersList);
        temp.addAll(other.getLottoNumbersList());
        return new LottoNumbersList(temp);
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    //로또번호끼리 비교
    public List<Rank> rankList(LottoNumbers winningList,int bonusNumber){
        ArrayList<Rank> rankList = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            List<Integer> temp = lottoNumbers.lottoNumberList();
            temp.retainAll(winningList.lottoNumberList());
            boolean matchBonus = lottoNumbers.lottoNumberList().contains(bonusNumber);
            rankList.add(Rank.valueOf(temp.size(), matchBonus));
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
