package lotto;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private LottoNumber first_lottoNumber;
    private LottoNumber second_lottoNumber;
    private LottoNumber third_lottoNumber;
    private LottoNumber fourth_lottoNumber;
    private LottoNumber fifth_lottoNumber;
    private LottoNumber sixth_lottoNumber;

    public LottoNumbers(LottoNumber first_lottoNumber, LottoNumber second_lottoNumber, LottoNumber third_lottoNumber, LottoNumber fourth_lottoNumber, LottoNumber fifth_lottoNumber, LottoNumber sixth_lottoNumber) {
        while (true) {
            try {
                ArrayList<LottoNumber> temp = new ArrayList<>(List.of(first_lottoNumber, second_lottoNumber, third_lottoNumber, fourth_lottoNumber, fifth_lottoNumber, sixth_lottoNumber));
                HashSet<LottoNumber> tempSet = new HashSet<>(temp);
                if (temp.size() != tempSet.size()) {
                    throw new IllegalArgumentException("중복 숫자");
                }

                this.first_lottoNumber = first_lottoNumber;
                this.second_lottoNumber = second_lottoNumber;
                this.third_lottoNumber = third_lottoNumber;
                this.fourth_lottoNumber = fourth_lottoNumber;
                this.fifth_lottoNumber = fifth_lottoNumber;
                this.sixth_lottoNumber = sixth_lottoNumber;
                break;
            }catch (IllegalArgumentException e){
                System.out.println("숫자 번호는 중복될 수 없습니다. 다시 입력하세요.");
            }

        }
    }

    //참,거짓값에 따라 자동 수동 생성
    public LottoNumbers(boolean auto) {
        if (auto) {
            List<Integer> numberList = IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            Collections.shuffle(numberList);

            this.first_lottoNumber = new LottoNumber(numberList.get(0));
            this.second_lottoNumber = new LottoNumber(numberList.get(1));
            this.third_lottoNumber = new LottoNumber(numberList.get(2));
            this.fourth_lottoNumber = new LottoNumber(numberList.get(3));
            this.fifth_lottoNumber = new LottoNumber(numberList.get(4));
            this.sixth_lottoNumber = new LottoNumber(numberList.get(5));
        } else {
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    int n3 = sc.nextInt();
                    int n4 = sc.nextInt();
                    int n5 = sc.nextInt();
                    int n6 = sc.nextInt();
                    ArrayList<Integer> temp = new ArrayList<>(List.of(n1, n2, n3, n4, n5, n6));

                    for (Integer integer : temp) {
                        if (integer>45||integer<1){
                            throw new Exception("범위 바깥의 숫자");
                        }
                    }

                    HashSet<Integer> tempSet = new HashSet<>(temp);
                    if (temp.size() != tempSet.size()) {
                        throw new IllegalArgumentException("중복 숫자");
                    }
                    this.first_lottoNumber = new LottoNumber(n1);
                    this.second_lottoNumber = new LottoNumber(n2);
                    this.third_lottoNumber = new LottoNumber(n3);
                    this.fourth_lottoNumber = new LottoNumber(n4);
                    this.fifth_lottoNumber = new LottoNumber(n5);
                    this.sixth_lottoNumber = new LottoNumber(n6);
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


    public LottoNumber getFirst_lottoNumber() {
        return first_lottoNumber;
    }

    public LottoNumber getSecond_lottoNumber() {
        return second_lottoNumber;
    }

    public LottoNumber getThird_lottoNumber() {
        return third_lottoNumber;
    }

    public LottoNumber getFourth_lottoNumber() {
        return fourth_lottoNumber;
    }

    public LottoNumber getFifth_lottoNumber() {
        return fifth_lottoNumber;
    }

    public LottoNumber getSixth_lottoNumber() {
        return sixth_lottoNumber;
    }

    public List<Integer> lottoNumberList() {
        return new ArrayList<>(List.of(first_lottoNumber.getNumber(), second_lottoNumber.getNumber(), third_lottoNumber.getNumber(), fourth_lottoNumber.getNumber(), fifth_lottoNumber.getNumber(), sixth_lottoNumber.getNumber()));
    }
}
