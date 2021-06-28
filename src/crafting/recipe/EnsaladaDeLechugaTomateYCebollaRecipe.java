package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaDeLechugaTomateYCebolla;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaDeLechugaTomateYCebollaRecipe extends ConcreteRecipe {

    public EnsaladaDeLechugaTomateYCebollaRecipe() {
        super("lechuga", "tomato", "onion");
    }

    protected Ingredient getResult() {
        return new EnsaladaDeLechugaTomateYCebolla(new Point(0, 0));
    }
}
