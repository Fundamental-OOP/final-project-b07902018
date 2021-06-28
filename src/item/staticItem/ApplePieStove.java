package item.staticItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;

public class ApplePieStove extends Stove {

    public ApplePieStove(Point location) {
        super(location);
        recipes.add(new ApplepieRecipe());
    }
    
}
