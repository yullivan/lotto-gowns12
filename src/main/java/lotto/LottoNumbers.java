package lotto;


import java.util.*;

public class LottoNumbers {
    private List<Integer> lottoList;

    public LottoNumbers(List<Integer> numberList) {
        if(numberList.size()<6){
            throw new IllegalArgumentException("숫자 리스트의 숫자가 6보다 적습니다.");
        }
        Collections.shuffle(numberList);
        this.lottoList = new ArrayList<>(List.of(numberList.get(0),numberList.get(1),numberList.get(2)
                ,numberList.get(3),numberList.get(4),numberList.get(5)));
    }

    public LottoNumbers(int number1, int number2, int number3, int number4, int number5, int number6) {
        List<Integer> temp = new ArrayList<>(List.of(number1,number2,number3,number4,number5,number6));
        Set<Integer> integers = new HashSet<>(temp);
        if (temp.size()!=integers.size()){
            System.out.println("숫자를 중복 입력하셨습니다. 다시 입력해주세요");
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다");
        }
        for (Integer i : temp) {
            if (i>45 || i<1){
                System.out.println("번호는 1~45까지만 입력가능합니다.");
                throw new IllegalArgumentException("번호는 1~45까지만 입력가능합니다.");
            }
        }
        this.lottoList = temp;
    }

    public List<Integer> getLottoList() {
        return lottoList;
    }

    public void print(){
        System.out.println(lottoList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoList, that.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoList);
    }
}
