package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //로또 구입
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Input.purchasePrice();
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int nonAutoCount = Input.nonAutoCount(purchasePrice);

        //로또 번호 선택
        LottoNumbersList lottoNumbersList = new LottoNumbersList(true, purchasePrice, nonAutoCount);
        if (nonAutoCount > 0) {
            System.out.println("수동으로 구매할 번호를 입력해주세요.");
            lottoNumbersList = lottoNumbersList.mergeLottoNumbersList(new LottoNumbersList(false, purchasePrice, nonAutoCount));
        }
        System.out.println("수동으로 " + nonAutoCount + "장, 자동으로 " + (purchasePrice / 1000 - nonAutoCount) + "개를 구매했습니다.");

        //선택된 로또번호 출력
        Output.choosePrint(lottoNumbersList);


        //지난주 당첨번호 입력
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        LottoNumbers winningList = new LottoNumbers(false);
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Input.bonusNumberInput();


        //당첨 통계
        System.out.println("당첨 통계");
        System.out.println("------------");
        List<Rank> rankList = lottoNumbersList.rankList(winningList, bonusNumber);
        Output.resultPrint(rankList);
        Output.calculateRateOfReturn(rankList, purchasePrice);
    }
}
