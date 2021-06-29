package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.*;

public class ApplePieStove extends Crafter {

    public ApplePieStove(Point location) {
        super(location, "applepiestove");
        recipes.add(new ApplepieRecipe());
        // recipes.add(new EnsaladaCompletaRecipe());
        // recipes.add(new EnsaladaDeLechugaMaizYCebollaRecipe());
        // recipes.add(new EnsaladaDeLechugaPepinoYCebollaRecipe());
        // recipes.add(new EnsaladaDeLechugaTomateYCebollaRecipe());
        // recipes.add(new EnsaladaDeTomateMaizYCebollaRecipe());
        // recipes.add(new EnsaladaDeTomatePepinoYCebollaRecipe());
    }
}
