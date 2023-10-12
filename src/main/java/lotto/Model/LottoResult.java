package lotto.Model;

import lotto.Model.Lotto;

//내가 입력한 것들을 입력하는 것들

public class LottoResult {
    private final Lotto lotto;
    private final int bonus;

    public LottoResult(Lotto lotto,int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public RankingLotto match(Lotto lottonum){
        int count =lottonum.countMatch(lotto); // 몇개가 일치하는지 확인해서 반환해주는 메소드
        boolean f = lottonum.containNumber(bonus);  //보너스가 일치하는지 확인하는 메소드
        return RankingLotto.valueOf(count,f);     //
    }
}
