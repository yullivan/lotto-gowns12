package lotto;

public class Count {
    int autoCount;
    int non_autoCount;

    public Count(int autoCount,int non_autoCount) {
        if (autoCount<0){
            throw new IllegalArgumentException("[ERROR] 횟수가 0회 미만입니다");
        }
        if (non_autoCount<0){
            throw new IllegalArgumentException("[ERROR] 횟수가 0회 미만입니다");
        }

        this.autoCount = autoCount;
        this.non_autoCount = non_autoCount;
    }

    public Count(PurchasePrice purchasePrice,int non_autoCount) {
        if (purchasePrice.getPrice()/1000-non_autoCount<0){
            throw new IllegalArgumentException("[ERROR] 구매 금액보다 로또 선택이 많습니다");
        }
        if (non_autoCount<0){
            throw new IllegalArgumentException("[ERROR] 횟수가 0회 미만입니다");
        }

        this.autoCount = purchasePrice.getPrice()/1000-non_autoCount;
        this.non_autoCount = non_autoCount;
    }


    public int getAutoCount() {
        return autoCount;
    }

    public int getNon_autoCount() {
        return non_autoCount;
    }
}
