package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output.purchasePriceRequest();
        PurchasePrice purchasePrice = Input.purchasePrice();
        System.out.println();

        Output.non_autoLottoCountRequest();
        Count purchaseCount = Input.purchaseCount(purchasePrice);
        System.out.println();

        Output.non_autoLottoNumbersListRequest();
        LottoNumbersList lottoNumbersList = new LottoNumbersList(false,purchaseCount);
        System.out.println();

        Output.purchaseCountOutput(purchaseCount);
        Output.LottoNumbersListOutput(lottoNumbersList,purchaseCount);
        System.out.println();

        Output.winningLottoNumbersRequest();
        LottoNumbers winningLottoNumbers = Input.winningLottoNumbersInput();
        Output.bonusLottoNumberRequest();
        LottoNumber bonusLottoNumber = Input.bonusLottoNumberInput();

        Output.result(lottoNumbersList.rankList(winningLottoNumbers,bonusLottoNumber),purchasePrice);
    }
}
