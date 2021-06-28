package crafting;

import java.util.ArrayList;
import item.Item;
import item.mobileItem.MobileItem;

public interface Recipe {

    public abstract boolean craftAble(ArrayList<MobileItem> items);

    public abstract MobileItem craft(ArrayList<MobileItem> items);
    
}
