package crafting;

import java.util.ArrayList;
import item.Item;
public interface Receipe {
    public boolean craftAble(ArrayList<Item> itm);
    public void craft(ArrayList<Item> itm);


}
