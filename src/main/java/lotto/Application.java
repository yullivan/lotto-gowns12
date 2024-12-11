package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        //로또 구입
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Util.purchasePrice();
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int nonAutoCount = Util.nonAutoCount(purchasePrice);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        if (nonAutoCount>0){
            System.out.println("수동으로 구매할 번호를 입력해주세요.");
            lottoNumbersList= Util.lottoNumbersList(nonAutoCount);
        }
        System.out.println("수동으로 "+nonAutoCount+"장, 자동으로"+(purchasePrice/1000-nonAutoCount)+"개를 구매했습니다.");


        //로또 번호 자동선택
        Util.autoLottoNumber(purchasePrice, nonAutoCount, lottoNumbersList);
        Util.choosePrint(lottoNumbersList);
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Util.bonusNumberInput();


        //지난주 당첨번호 입력
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        LottoNumbers winningList = Util.winningNumbers();


        //당첨 통계
        System.out.println("당첨 통계");
        System.out.println("------------");
        List<Rank> rankList = Util.rankList(lottoNumbersList,winningList,bonusNumber);
        Util.resultPrint(rankList);
        Util.calculateRateOfReturn(rankList,purchasePrice);
    }
}
