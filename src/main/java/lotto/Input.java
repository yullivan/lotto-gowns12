package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    //구매금액 입력
    public static int purchasePrice() {
        Scanner sc = new Scanner(System.in);
        int purchasePrice = 0;
        while (true) {
            try {
                purchasePrice = sc.nextInt();
                if (purchasePrice % 1000 != 0 || purchasePrice < 1000) {
                    throw new IllegalArgumentException("금액이 정확하지 않습니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("금액이 정확하지 않습니다. 다시 입력하세요");
            }
        }
        return purchasePrice;
    }

    //수동 로또 개수 입력
    public static int nonAutoCount(int purchasePrice) {
        Scanner sc = new Scanner(System.in);
        int nonAutoCount = -1;
        while (nonAutoCount == -1) {
            try {
                nonAutoCount = sc.nextInt();
                if (nonAutoCount > purchasePrice / 1000) {
                    System.out.println("구매금액보다 많이 선택하셨습니다.");
                    throw new IllegalArgumentException("구매금액보다 많이 선택하셨습니다.");
                }
                if (nonAutoCount < 0) {
                    System.out.println("잘못된 숫자를 입력하셨습니다.");
                    throw new IllegalArgumentException("잘못된 숫자 입력");
                }
            } catch (IllegalArgumentException e) {
                nonAutoCount = -1;
            }
        }
        return nonAutoCount;
    }

    //보너스번호 입력
    public static int bonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
