package lotto.Model;
import java.util.*;
public class Lotto {

    private List<Integer> numbers;

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    public void setNumbers(List<Integer> numbers){
        this.numbers=numbers;
    }



    //정답이 몇개인지 알려줌

    //이걸 고쳐야됨
    public int countMatch(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (containNumber(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    //리스트에 값이 있는지 확인
    public boolean containNumber (int number){
        return numbers.contains(number);
    }

}
