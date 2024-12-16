package lotto;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> temp = new HashSet<>(lottoNumbers);

        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다");
        }
        if (lottoNumbers.size() != temp.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers() {
        List<Integer> integers = new ArrayList<>(IntStream.rangeClosed(1,45)
                .boxed()
                .toList());
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        Collections.shuffle(integers);

        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(integers.get(i)));
        }

        HashSet<LottoNumber> temp = new HashSet<>(lottoNumbers);

        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다");
        }
        if (lottoNumbers.size() != temp.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String non_autoInput) {
        String regex = "^(\\d{1,2})(,(\\d{1,2})){5}$";
        if (!non_autoInput.matches(regex)){
            throw new IllegalArgumentException("[ERROR] 입력 형식을 지켜주세요.[번호1,번호2,번호3,번호4,번호5,번호6]");
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        non_autoInput=non_autoInput.replaceAll(" ","");

        for (String s : non_autoInput.split(",")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }

        HashSet<LottoNumber> temp = new HashSet<>(lottoNumbers);

        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다");
        }
        if (lottoNumbers.size() != temp.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getToIntegerList() {
        List<Integer> integers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            integers.add(lottoNumber.getNumber());
        }
        Collections.sort(integers);

        return integers;
    }

    public Rank matchCount(LottoNumbers givenWinningLottoNumbers, LottoNumber givenBonusNumber) {
        List<LottoNumber> temp = new ArrayList<>(lottoNumbers);
        temp.retainAll(givenWinningLottoNumbers.getLottoNumbers());

        int matchCount = temp.size();
        boolean matchBonus = lottoNumbers.contains(givenBonusNumber);

        return Rank.valueOf(matchCount,matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
