package scoring;

import item.mobileItem.MobileItem;

public class ScoreApplePie extends ScoreConversion {

    public ScoreApplePie(MobileItem item) {
        super(item);
         
    }

    @Override
    public int getScore() {
         
        return 87;
    }
    
}
