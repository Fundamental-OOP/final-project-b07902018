package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;

import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;

public class FriedEggRecipe extends ConcreteRecipe {

    public FriedEggRecipe() {
        super("rawegg");
    }

    protected Ingredient getResult() {
        return new FriedEgg(new Point(0, 0));
    }
}
