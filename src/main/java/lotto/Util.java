package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public static int purchasePrice() {
        Scanner sc = new Scanner(System.in);
        int purchasePrice = sc.nextInt();
        if (purchasePrice % 1000 != 0 || purchasePrice < 1000) {
            System.out.println("금액이 정확하지 않습니다.");
            throw new IllegalArgumentException("금액이 정확하지 않습니다.");
        }
        return purchasePrice;
    }


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

    public static List<LottoNumbers> lottoNumbersList(int nonAutoCount) {
        Scanner sc = new Scanner(System.in);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();


        for (int i = 0; i < nonAutoCount; i++) {

            while (true) {
                try {
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    int n3 = sc.nextInt();
                    int n4 = sc.nextInt();
                    int n5 = sc.nextInt();
                    int n6 = sc.nextInt();

                    lottoNumbersList.add(new LottoNumbers(n1, n2, n3, n4, n5, n6));

                    if (i < nonAutoCount - 1) {
                        System.out.println("다음 번호를 입력하세요.");
                    }
                    break;
                } catch (IllegalArgumentException ignored){}
            }

        }
        return lottoNumbersList;
    }

    public static void lottoNumber(int purchasePrice, int nonAutoCount, List<LottoNumbers> lottoNumbersList) {
        List<Integer> numberList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toCollection(ArrayList::new));

        int count = purchasePrice / 1000 - nonAutoCount;

        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(numberList);
            lottoNumbersList.add(lottoNumbers);
        }

    }

    public static void choosePrint(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            Collections.sort(lottoNumber.getLottoList());
            lottoNumber.print();
        }
    }

    public static LottoNumbers winningList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            temp.add(scanner.nextInt());
        }

        return new LottoNumbers(temp);
    }

    public static int bonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Rank> rankList(List<LottoNumbers> lottoNumbersList, LottoNumbers winningList, int bonusNumber) {
        ArrayList<Rank> rankList = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            List<Integer> temp = new ArrayList<>(lottoNumbers.getLottoList());
            temp.retainAll(winningList.getLottoList());
            boolean matchBonus = lottoNumbers.getLottoList().contains(bonusNumber);
            rankList.add(Rank.valueOf(temp.size(), matchBonus));
        }

        return rankList;
    }

    public static void resultPrint(List<Rank> rankList) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.SECOND)) {
                System.out.println("5개 일치 ,보너스 볼 일치(30000000원) " + Collections.frequency(rankList, rank) + "개");
            } else
                System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + Collections.frequency(rankList, rank) + "개");
        }
    }

    public static void calculateRateOfReturn(List<Rank> rankList, int purchasePrice) {
        double sum = 0;
        for (Rank rank : rankList) {
            sum += rank.getWinningMoney();
        }

        System.out.println("총 수익률은 " + Math.floor(sum / purchasePrice * 100) / 100 + "입니다.");
    }
}
