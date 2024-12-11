package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {

    //선택된 로또 번호 출력
    public static void choosePrint(LottoNumbersList lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList.getLottoNumbersList()) {
            int n1 = lottoNumbers.getFirst_lottoNumber().getNumber();
            int n2 = lottoNumbers.getSecond_lottoNumber().getNumber();
            int n3 = lottoNumbers.getThird_lottoNumber().getNumber();
            int n4 = lottoNumbers.getFourth_lottoNumber().getNumber();
            int n5 = lottoNumbers.getFifth_lottoNumber().getNumber();
            int n6 = lottoNumbers.getSixth_lottoNumber().getNumber();
            ArrayList<Integer> temp = new ArrayList<>(List.of(n1, n2, n3, n4, n5, n6));
            System.out.println(temp);
        }
    }

    //결과창 출력
    public static void resultPrint(List<Rank> rankList) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.SECOND)) {
                System.out.println("5개 일치 ,보너스 볼 일치(30000000원) " + Collections.frequency(rankList, rank) + "개");
            } else
                System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + Collections.frequency(rankList, rank) + "개");
        }
    }

    //수익율 출력
    public static void calculateRateOfReturn(List<Rank> rankList, int purchasePrice) {
        double sum = 0;
        for (Rank rank : rankList) {
            sum += rank.getWinningMoney();
        }

        System.out.println("총 수익률은 " + Math.floor(sum / purchasePrice * 100) / 100 + "입니다.");
    }
}
