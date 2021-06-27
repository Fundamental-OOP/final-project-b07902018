package crafting;

import java.util.ArrayList;

import item.Item;

public class Crafter {
    ArrayList<Item> inv;
    public ArrayList<Receipe> rcps;
    public Crafter(){
        inv = new ArrayList<>();
        rcps = new ArrayList<>();
    }
    public void putItem(Item i){
        inv.add(i);
        checkEnv();


    }
    public boolean isEmpty(){
        return inv.isEmpty();
    }
    public Item getItem(){
        var i = inv.get(0);
        inv.remove(i);
        return i;
    }
    private void checkEnv(){
        for (var r : rcps){
            if(r.craftAble(inv)){
                r.craft(inv);
                checkEnv();
            }
        }
    }

}
