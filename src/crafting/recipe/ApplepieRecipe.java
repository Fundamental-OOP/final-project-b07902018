package crafting.recipe;

import java.awt.Point;
import java.util.ArrayList;

import crafting.Recipe;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.Apple;
import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.Pie;
import model.World;

public class ApplepieRecipe implements Recipe{

    public ApplepieRecipe(){
        
    }

    @Override
    public boolean craftAble(ArrayList<MobileItem> items) {
        boolean hasApple = false;
        boolean hasPie = false;
        for(MobileItem item : items){
            if(item instanceof Apple){
                hasApple = true;
            }
            if(item instanceof Pie){
                hasPie = true;
            }
        }
        return (hasApple & hasPie);
    }

    @Override
    public MobileItem craft(ArrayList<MobileItem> items) {
        int removeApple = 1;
        int removePie = 1;
        for(MobileItem item : items){
            if(item instanceof Apple && removeApple > 0){
                item.getWorld().removeSprite(item);
                items.remove(item);
                break;
            }
        }
        for(MobileItem item : items){
            if(item instanceof Pie && removePie > 0){
                item.getWorld().removeSprite(item);
                items.remove(item);
                break;
            }
        }
        return new ApplePie(new Point(0,0));

    }
    
}
