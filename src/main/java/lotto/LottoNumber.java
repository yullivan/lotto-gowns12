package lotto;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("잘못된 숫자");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
