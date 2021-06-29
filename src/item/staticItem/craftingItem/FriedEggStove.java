package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplePieRecipe;
import crafting.recipe.FriedEggRecipe;

public class FriedEggStove extends Crafter {

    public FriedEggStove(Point location) {
        super(location, "friedeggstove");
        //recipes.add(new ApplepieRecipe());
        recipes.add(new FriedEggRecipe());
    }
    
}
