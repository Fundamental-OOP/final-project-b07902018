package crafting.order;

import java.util.ArrayList;

import crafting.Recipe;
import item.Item;
import item.mobileItem.MobileItem;
import scoring.Score;

public abstract class Order implements Recipe {
    Score s;
    ArrayList<Item> req;
    int point  = 10;

    public Order(Score sc){
        s = sc;
        req = new ArrayList<>();
    }

    @Override
    public MobileItem craft(ArrayList<MobileItem> items){
        s.setScore(s.getScore()+point);
        for (var t: req){
            items.remove(t);
        }
        return null;
    }
}
