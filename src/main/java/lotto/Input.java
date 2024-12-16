package lotto;

import java.util.Scanner;

public class Input {
    public static PurchasePrice purchasePrice(){
        Scanner sc = new Scanner(System.in);
        PurchasePrice purchasePrice;
        while (true){
            try {
                purchasePrice = new PurchasePrice(sc.nextInt());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("금액은 천원단위로 입력 가능합니다.");
            }
        }
        return purchasePrice;
    }

    public static Count purchaseCount(PurchasePrice purchasePrice){
        Scanner sc = new Scanner(System.in);
        Count purchaseCount;
        while (true){
            try {
                purchaseCount = new Count(purchasePrice,sc.nextInt());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("횟수가 0회 미만입니다");
            }
        }
        return purchaseCount;
    }

    public static LottoNumbers non_autoLottoNumberInput(){
        Scanner sc = new Scanner(System.in);
        LottoNumbers non_autoLottoNumberInput;

        while(true){
            try {
                non_autoLottoNumberInput = new LottoNumbers(sc.nextLine());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("입력 형식을 지켜주세요.[번호1,번호2,번호3,번호4,번호5,번호6]");
            }
        }

        return non_autoLottoNumberInput;
    }

    public static LottoNumbers winningLottoNumbersInput() {
        Scanner sc = new Scanner(System.in);
        return Input.non_autoLottoNumberInput();
    }

    public static LottoNumber bonusLottoNumberInput() {
        Scanner sc = new Scanner(System.in);
        return new LottoNumber(sc.nextInt());
    }
}
