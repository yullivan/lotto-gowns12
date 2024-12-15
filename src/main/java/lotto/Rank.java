package lotto;

public enum Rank {
    First(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    Miss(0, 0);

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank value : Rank.values()) {
            if (value.getMatchCount() == matchCount) {
                if (value.getMatchCount() == 5 && matchBonus) {
                    return value;
                } else if (value.getMatchCount() == 5) {
                    return THIRD;
                }
                return value;
            }
        }
        return Miss;
    }


}
