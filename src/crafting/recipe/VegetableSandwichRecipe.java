package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;

import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;
import item.mobileItem.ingredient.VegetableSandwich;

public class VegetableSandwichRecipe extends ConcreteRecipe {

    public VegetableSandwichRecipe() {
        super("bread", "spinach");
    }

    protected Ingredient getResult() {      
        return new VegetableSandwich(new Point(0, 0));
    }
}
