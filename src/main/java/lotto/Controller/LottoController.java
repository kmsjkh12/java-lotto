package lotto.Controller;


//사용자의 명령을 읽어서 모델로 보낸다.


import lotto.Model.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class LottoController {

    private static AmountLottoModel amountLottoModel;
    private static int setMoney = 0;

    //run
    public void run(){
        start();
    }

    //전체적인 메소드 진행
    public void start(){
        int ticketCount = playerCount(); //티켓 갯수
        List<Lotto> lotto = RandomLotto(ticketCount);  // 로또 번호 생성 끝 전체 로또 번호를 얘가 가지고 있어야함
        OutputView.buyLottoPrint(ticketCount,lotto);   // 자동 생성 로또 번호 출력
        Lotto winningLotto = WinningLotto();           // 당첨 번호
        int bonus = InputView.inputBonus();            // 보너스 번호
        LottoResult lottoResult = new LottoResult(winningLotto, bonus);
        HashMap<RankingLotto, Integer> hashLotto = RankingLotto.hashLottoInitial();
        int amount= 0;
        for(int i = 0 ; i< lotto.size();i++){
            RankingLotto rankingLotto = lottoResult.match(lotto.get(i));
            hashLotto.put(rankingLotto,hashLotto.get(rankingLotto)+1);
        }

        for( RankingLotto plotto: RankingLotto.values()){
            if (plotto != RankingLotto.MISS) {
                System.out.print(plotto.getLine() + " ("+ plotto.getReward()+"원)" + " - ");
                System.out.println(hashLotto.get(plotto)+"개");
            if(hashLotto.get(plotto) >0){
                int reward = Integer.parseInt(plotto.getReward().replace(",",""));
                amount += reward * hashLotto.get(plotto);
            }
        }}

        double profitPercentage = ((double)amount / (double)setMoney * 100.0);


        OutputView.makeMoney(profitPercentage) ;
    }
    //금액에 따른 로또 구매 갯수 알려줌
    public Integer playerCount(){
        setMoney= InputView.inputAcount();
        amountLottoModel = new AmountLottoModel(setMoney);
        return amountLottoModel.calculateLotto();
    }

    //로또 갯수에 따른 로또 랜덤 뽑기
    public List<Lotto> RandomLotto(Integer amount){
        List<Lotto> lottonumber = new ArrayList<>();
        for(int i = 0 ; i < amount ; i++) {
            Lotto lotto = MakeLottoNumber.randomLottoList();
            lottonumber.add(lotto);
        }

        return lottonumber;
    }



    //사용자가 입력하는 당첨된 로또 번호
    public Lotto WinningLotto(){
        List<Integer> numberList = new ArrayList<>();
        String date[] = InputView.inputLotto().split(",");
        for(int i = 0 ; i < date.length;i++){
            numberList.add(Integer.parseInt(date[i]));
        }
        Lotto lotto = new Lotto(numberList);
        return lotto;
    }
}
