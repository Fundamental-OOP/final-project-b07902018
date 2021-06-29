package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;

import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;

public class ApplePieRecipe extends ConcreteRecipe {

    public ApplePieRecipe() {
        super("apple", "pie");
    }

    protected Ingredient getResult() {
        return new ApplePie(new Point(0, 0));
    }
}
