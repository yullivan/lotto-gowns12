package lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberCreate {
    public static List<LottoNumbers> autoNumberCreate(int count){
        List<LottoNumbers> autoNumberList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoNumberList.add(new LottoNumbers(true));
        }
        return autoNumberList;
    }

    public static List<LottoNumbers> nonAutoNumberCreate(int count){
        List<LottoNumbers> nonAutoNumberList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nonAutoNumberList.add(new LottoNumbers(false));
            if (i < count - 1) {
                System.out.println("다음 번호를 입력하세요.");
            }
        }
        return nonAutoNumberList;
    }
}
