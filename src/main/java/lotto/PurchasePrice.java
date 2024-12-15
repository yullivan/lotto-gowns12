package lotto;

public class PurchasePrice {
    private int price;

    public PurchasePrice(int price) {
        if (price<1000 || price%1000!=0){
            throw new IllegalArgumentException("[ERROR] 금액은 천원단위로 입력가능합니다");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
