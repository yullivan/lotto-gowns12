package lotto;

import java.util.List;

public class Output {
    public static void purchasePriceRequest() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void non_autoLottoCountRequest() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void non_autoLottoNumbersListRequest() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void LottoNumbersListOutput(LottoNumbersList lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList.getLottoNumbersList()) {
            System.out.println(lottoNumbers.getToIntegerList());
        }
    }

    public static void purchaseCountOutput(Count purchaseCount) {
        System.out.println("수동으로 " + purchaseCount.getNon_autoCount() + "장, 자동으로 " + purchaseCount.getAutoCount() + "개를 구매했습니다.");
    }

    public static void winningLottoNumbersRequest() {
        System.out.println("지난 주 당첨번호를 입력해주세요");
    }


    public static void bonusLottoNumberRequest() {
        System.out.println("보너스 번호를 입력해주세요");
    }

    public static void result(List<Rank> ranks, PurchasePrice purchasePrice) {
        System.out.println("당첨 통계");
        System.out.println("------------");
        int totalReturn = 0;

        ranks.removeIf(s -> s.equals(Rank.Miss));
        for (Rank value : Rank.values()) {
            if (value.equals(Rank.Miss)) {
                continue;
            }
            int count = 0;
            while (ranks.contains(value)) {
                count++;
                ranks.remove(value);
            }
            if (value.equals(Rank.SECOND)) {
                System.out.println(value.getMatchCount() + "개 일치, 보너스볼 일치 (" + value.getWinningMoney() + "원)- " + count + "개");
            } else {
                System.out.println(value.getMatchCount() + "개 일치 (" + value.getWinningMoney() + "원)- " + count + "개");
            }

            totalReturn += count * value.getWinningMoney();
        }

        double returnRate = Math.floor((double) totalReturn / purchasePrice.getPrice() * 100) / 100.0;
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }
}
