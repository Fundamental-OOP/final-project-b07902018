package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;
import crafting.recipe.FriedEggRecipe;
import crafting.recipe.SaladRecipe;
import item.mobileItem.MobileItem;

public class SaladBowl extends Crafter {

    public SaladBowl(Point location) {
        super(location, "saladbowl");
        //recipes.add(new ApplepieRecipe());
        recipes.add(new SaladRecipe());
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        int x = this.getX();
        int y = this.getY();
        int w = this.getRange().width;
        int h = this.getRange().height;
        int index = items.indexOf(item);

        return new Point(x + 10 + index * 30, y); 
    }
    
}
