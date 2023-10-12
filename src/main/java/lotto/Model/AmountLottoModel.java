package lotto.Model;


//여기서 금액에 관한 예외 에러 처리하기

public class AmountLottoModel {

    public static final Integer LOTTO_TICKET = 1000;
    public static Integer amount;


    //가격에 관한 처리
    public AmountLottoModel(Integer amount){
        ValidateAmount(amount);
        this.amount= amount;
    }
    //예외 처리
    private void ValidateAmount(int amountNum) {
        validateNatural(amountNum);
        validateDivisible(amountNum);
    }

    //가격이 0원 이하면 예외 처리
    private void validateDivisible(int amountNum) {
        if(amountNum<=0){
            throw new IllegalArgumentException();
        }
    }

    //0으로 안떨어지면 예외처리
    private void validateNatural(int amountNum) {
        if(amountNum % LOTTO_TICKET!= 0){
            throw new IllegalArgumentException();
        }

    }


    //금액에 따른 로또 갯수 반환
    public Integer calculateLotto(){
        return amount/LOTTO_TICKET;
    }
}
