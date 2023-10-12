package lotto.View;
import camp.nextstep.edu.missionutils.Console;

//인풋에 관한 뷰
//입력에 관한 것들이 대체적으로 들어감

public class InputView {
    public static final String INPUT_ACOUNT_MASSAGE= "구입금액을 입력해 주세요.";
    public static final String INPUT_LOTTO_MASSAGE= "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MASSAGE= "보너스 번호를 입력해 주세요.";


    //금액 입력
    public static Integer inputAcount(){
        System.out.println(INPUT_ACOUNT_MASSAGE);
        return Integer.parseInt(Console.readLine());
    }

    //당첨 번호 입력
    public static String inputLotto(){
        System.out.println(INPUT_LOTTO_MASSAGE);
        return Console.readLine();
    }

    //보너스 입력
    public static Integer inputBonus(){
        System.out.println(INPUT_BONUS_MASSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
