package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaDeTomatePepinoYCebolla;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaDeTomatePepinoYCebollaRecipe extends ConcreteRecipe {

    public EnsaladaDeTomatePepinoYCebollaRecipe() {
        super("tomato", "pepino", "onion");
    }

    protected Ingredient getResult() {
        return new EnsaladaDeTomatePepinoYCebolla(new Point(0, 0));
    }
}
