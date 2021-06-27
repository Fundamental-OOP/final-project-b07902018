package crafting.receipes;

import java.util.ArrayList;

import crafting.Receipe;
import item.Item;

public class TwoToOne implements Receipe{

    @Override
    public boolean craftAble(ArrayList<Item> itm) {
        // TODO Auto-generated method stub
        return itm.size() > 1;
    }

    @Override
    public void craft(ArrayList<Item> itm) {
        itm.remove(1);
        System.out.println("Craft one item");
        
    } 
    
}
