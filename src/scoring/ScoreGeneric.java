package scoring;

import item.mobileItem.MobileItem;

public class ScoreGeneric extends ScoreConversion {

    int score;

    public ScoreGeneric(MobileItem item, int score) {
        super(item);
        this.score = score;
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return score;
    }
    
}
