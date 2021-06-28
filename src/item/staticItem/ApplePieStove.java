package item.staticItem;

import java.awt.Point;

import crafting.recipe.*;

public class ApplePieStove extends Stove {

    public ApplePieStove(Point location) {
        super(location);
        recipes.add(new ApplepieRecipe());
        recipes.add(new EnsaladaCompletaRecipe());
        recipes.add(new EnsaladaDeLechugaMaizYCebollaRecipe());
        recipes.add(new EnsaladaDeLechugaPepinoYCebollaRecipe());
        recipes.add(new EnsaladaDeLechugaTomateYCebollaRecipe());
        recipes.add(new EnsaladaDeTomateMaizYCebollaRecipe());
        recipes.add(new EnsaladaDeTomatePepinoYCebollaRecipe());
    }
}
