package crafting.recipe;

import java.util.ArrayList;

import crafting.Recipe;
import item.Item;
import item.mobileItem.MobileItem;

public class TwoToOne implements Recipe {

    @Override
    public boolean craftAble(ArrayList<MobileItem> itm) {
        // TODO Auto-generated method stub
        return itm.size() > 1;
    }

    @Override
    public MobileItem craft(ArrayList<MobileItem> itm) {
        itm.remove(1);
        System.out.println("Craft one item");
        return null;
    }
    
}
