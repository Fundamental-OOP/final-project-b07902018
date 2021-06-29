package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;
import crafting.recipe.FriedEggRecipe;
import crafting.recipe.SaladRecipe;

public class SaladBowl extends Crafter {

    public SaladBowl(Point location) {
        super(location, "saladbowl");
        //recipes.add(new ApplepieRecipe());
        recipes.add(new SaladRecipe());
    }
    
}
