package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;

import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;
import item.mobileItem.ingredient.Salad;

public class SaladRecipe extends ConcreteRecipe {

    public SaladRecipe() {
        super("tomato", "spinach");
    }

    protected Ingredient getResult() {      
        return new Salad(new Point(0, 0));
    }
}
