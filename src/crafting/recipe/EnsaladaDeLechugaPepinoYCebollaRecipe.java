package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaDeLechugaPepinoYCebolla;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaDeLechugaPepinoYCebollaRecipe extends ConcreteRecipe {

    public EnsaladaDeLechugaPepinoYCebollaRecipe() {
        super("lechuga", "pepino", "onion");
    }

    protected Ingredient getResult() {
        return new EnsaladaDeLechugaPepinoYCebolla(new Point(0, 0));
    }
}
