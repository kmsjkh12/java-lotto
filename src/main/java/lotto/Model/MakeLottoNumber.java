package lotto.Model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MakeLottoNumber {
    private static List<Integer> lottoNumberList;
    public MakeLottoNumber(List<Integer> lottoNumberList){
        this.lottoNumberList=lottoNumberList;

    }


    //로또 번호 6개 랜덤 선택
    //이 단에서는 문제 없음

    public static Lotto randomLottoList(){
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(list);
    }
    //로또 갯수에 따른 로또 번호 뽑기
}
