package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;
import item.mobileItem.ingredient.CheeseEggSandwich;


import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;
import model.SpriteShape;

public class CheeseEggSandwichRecipe extends ConcreteRecipe {

    public CheeseEggSandwichRecipe(SpriteShape productShape) {
        super(productShape, "bread", "friedegg", "cheese");
    }

    protected Ingredient getResult() {      
        return new CheeseEggSandwich(null, productShape);
    }
}
