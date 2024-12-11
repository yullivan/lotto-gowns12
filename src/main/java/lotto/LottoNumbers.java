package lotto;


import java.util.*;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        while (true) {
            try {

                HashSet<LottoNumber> temp = new HashSet<>(lottoNumbers);
                if (temp.size() != lottoNumbers.size()) {
                    throw new IllegalArgumentException("중복 숫자");
                }

                this.lottoNumbers = lottoNumbers;
                break;
            }catch (IllegalArgumentException e){
                System.out.println("숫자 번호는 중복될 수 없습니다. 다시 입력하세요.");
            }

        }
    }

    //참,거짓값에 따라 자동 수동 생성
    public LottoNumbers(boolean auto) {
        if (auto) {
            this.lottoNumbers = NumberCreate.autoNumberCreate();
        } else {
            while (true) {
                try {
                    this.lottoNumbers = NumberCreate.nonAutoNumberCreate();
                    break;
                }
                catch (IllegalArgumentException e) {
                    System.out.println("숫자 번호는 중복될 수 없습니다. 다시 입력해주세요");
                } catch (Exception e) {
                    System.out.println("숫자 번호는 1부터 45 사이입니다");
                }
            }
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getToIntegerList(){
        List<Integer> integers = new ArrayList<>(List.of());
        for (LottoNumber lottoNumber : lottoNumbers) {
            integers.add(lottoNumber.getNumber());
        }
        return integers;
    }
}
