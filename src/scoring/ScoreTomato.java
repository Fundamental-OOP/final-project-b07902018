package scoring;

import item.mobileItem.MobileItem;

public class ScoreTomato extends ScoreConversion {

    public ScoreTomato(MobileItem item) {
        super(item);
         
    }

    @Override
    public int getScore() {
         
        return 5;
    }
    
}
