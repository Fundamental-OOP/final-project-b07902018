package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;
import crafting.recipe.FriedEggRecipe;
import item.mobileItem.MobileItem;

public class FriedEggStove extends Crafter {

    public FriedEggStove(Point location) {
        super(location, "friedeggstove");
        //recipes.add(new ApplepieRecipe());
        recipes.add(new FriedEggRecipe());
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        int x = this.getX();
        int y = this.getY();
        int w = this.getRange().width;
        int h = this.getRange().height;
        int index = items.indexOf(item);

        return new Point(x + 10 + index * 30, y + (h / 6)); 
    }
    
}
