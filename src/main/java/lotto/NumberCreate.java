package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCreate {
    public static List<LottoNumbers> autoNumbersCreate(int count) {
        List<LottoNumbers> autoNumberList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoNumberList.add(new LottoNumbers(true));
        }
        return autoNumberList;
    }

    public static List<LottoNumbers> nonAutoNumbersCreate(int count) {
        List<LottoNumbers> nonAutoNumberList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nonAutoNumberList.add(new LottoNumbers(false));
            if (i < count - 1) {
                System.out.println("다음 번호를 입력하세요.");
            }
        }
        return nonAutoNumberList;
    }

    public static List<LottoNumber> autoNumberCreate() {
        List<Integer> numberList = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(numberList);

        return numberList.stream()
                .map(LottoNumber::new)
                .skip(0)
                .limit(6)
                .toList();
    }

    public static List<LottoNumber> nonAutoNumberCreate() throws Exception {


        Scanner sc = new Scanner(System.in);
        List<LottoNumber> lottoNumbers = new ArrayList<>(List.of());
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(sc.nextInt()));
        }
        LottoNumbers temp = new LottoNumbers(lottoNumbers);

        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.getNumber() > 45 || lottoNumber.getNumber() < 1) {
                throw new Exception("범위 바깥의 숫자");
            }
        }

        HashSet<Integer> tempSet = new HashSet<>(temp.getToIntegerList());
        if (lottoNumbers.size() != tempSet.size()) {
            throw new IllegalArgumentException("중복 숫자");
        }

        return lottoNumbers;
    }

}
