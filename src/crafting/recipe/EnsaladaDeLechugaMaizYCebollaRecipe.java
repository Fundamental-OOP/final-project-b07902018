package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaDeLechugaMaizYCebollaRecipe extends ConcreteRecipe {

    public EnsaladaDeLechugaMaizYCebollaRecipe() {
        super("lechuga", "maiz", "onion");
    }

    protected Ingredient getResult() {
        return new EnsaladaDeLechugaMaizYCebolla(new Point(0, 0));
    }
}
