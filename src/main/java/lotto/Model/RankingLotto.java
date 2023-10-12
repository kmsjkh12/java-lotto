package lotto.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public enum RankingLotto {
    FIVE(5,3,"5,000","3개 일치"),
    FOUR(4,4,"50,000","4개 일치"),
    THREE(3,5,"1,500,000", "5개 일치"),
    TWO(2,5,"30,000,000", "5개 일치, 보너스 볼 일치"),
    ONE(1,6,"2,000,000,000", "6개 일치"),


    MISS(0,0,"0","");
    // 로또 최소 등수, 3개이상은 뽑아야함
    private static int MIN_LOTTO = 3;

    RankingLotto(int ranking, int lotto, String reward, String line) {
        this.ranking = ranking;
        this.lotto=lotto;
        this.reward=reward;
        this.line=line;
    }
    int ranking;
    int lotto;
    String reward;
    String line;
    public static RankingLotto valueOf(int lotto, boolean matchBonus){
        //3개 보다 작으면 miss반환
        if(lotto < MIN_LOTTO){
            return MISS;
        }
        // 5개에 보너스가 트루면 이등
        if(TWO.matchCount(lotto) && matchBonus){
            return TWO;
        }

        //그런것이 아니면 본인의 등수를 매김
        //이등이 절대 아님
        for(RankingLotto ranking : values()){
            if(ranking.matchCount(lotto) && ranking != TWO){
                return ranking;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public static HashMap<RankingLotto,Integer> hashLottoInitial() {
        HashMap<RankingLotto, Integer> hashLotto = new HashMap<>();


        for(RankingLotto rankingLotto : RankingLotto.values()){
            hashLotto.put(rankingLotto, 0);
        }

        return hashLotto;
    }

    private boolean matchCount(int lotto) {
        return this.lotto ==lotto;
    }

    public int getLotto() {
        return lotto;
    }
    public String getLine(){
        return line;
    }

    public String getReward() {
        return reward;
    }
}
