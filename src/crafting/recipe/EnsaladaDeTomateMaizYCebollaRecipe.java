package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaDeTomateMaizYCebolla;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaDeTomateMaizYCebollaRecipe extends ConcreteRecipe {

    public EnsaladaDeTomateMaizYCebollaRecipe() {
        super("tomato", "maiz", "onion");
    }

    protected Ingredient getResult() {
        return new EnsaladaDeTomateMaizYCebolla(new Point(0, 0));
    }
}
