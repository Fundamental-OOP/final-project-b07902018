package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.*;
import model.SpriteShape;

public class ApplePieStove extends Crafter {

    public ApplePieStove(Point location, SpriteShape shape, SpriteShape productShape) {
        super(location, shape, productShape, "applepiestove");
        recipes.add(new ApplepieRecipe(productShape));
        // recipes.add(new EnsaladaCompletaRecipe());
        // recipes.add(new EnsaladaDeLechugaMaizYCebollaRecipe());
        // recipes.add(new EnsaladaDeLechugaPepinoYCebollaRecipe());
        // recipes.add(new EnsaladaDeLechugaTomateYCebollaRecipe());
        // recipes.add(new EnsaladaDeTomateMaizYCebollaRecipe());
        // recipes.add(new EnsaladaDeTomatePepinoYCebollaRecipe());
    }
}
