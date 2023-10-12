package lotto.View;


import lotto.Model.Lotto;
import lotto.Model.MakeLottoNumber;

import java.util.List;

//아웃풋에 관한 뷰
//대체로 결과값이 들어감
public class OutputView {


    public static final String BUY_LOTTO_MASSAGE= "개를 구매했습니다.";
    public static final String LOTTO_RESULT_MASSAGE = "총 수익률은 %f 입니다.";

    //수량에 관한 메소드
    public static void buyLottoPrint(Integer number,List<Lotto> lottoList ){
        System.out.println(number + BUY_LOTTO_MASSAGE);
        allLottoPrint(lottoList);
        //로또 번호를 생성해서 출력해줌
    }

    //당첨 전체 번호에 관한 메소드
    public static void allLottoPrint(List<Lotto> lottoList){
       for(int i = 0 ;i< lottoList.size();i++){  //로또 리스트만큼
           System.out.print("[");
           for(int j = 0; j < 6; j++){  //로또에 숫자만큼
               System.out.print(lottoList.get(i).getNumbers().get(j));
               if(j != 5) {
                   System.out.print(", ");
               }
           }
           System.out.println("]");
       }
    }

   public static void makeMoney(double amount){
        System.out.print("총 수익률은 " + amount + "%입니다.");
   }



}
