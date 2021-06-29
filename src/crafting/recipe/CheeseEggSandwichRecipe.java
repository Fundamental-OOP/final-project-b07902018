package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.CheeseEggSandwich;
import item.mobileItem.ingredient.EnsaladaDeLechugaMaizYCebolla;

import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;

public class CheeseEggSandwichRecipe extends ConcreteRecipe {

    public CheeseEggSandwichRecipe() {
        super("bread", "friedegg", "cheese");
    }

    protected Ingredient getResult() {      
        return new CheeseEggSandwich(new Point(0, 0));
    }
}
