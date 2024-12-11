package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        Rank[] ranks = values();
        if (countOfMatch==5&&matchBonus){
            return SECOND;
        }
        if (countOfMatch==5){
            return THIRD;
        }
        if (countOfMatch==1||countOfMatch==2){
            return MISS;
        }
        for (Rank rank : ranks) {
            if (rank.getCountOfMatch()==countOfMatch){
                return rank;
            }
        }
        return null;
    }


}

