package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.ApplePie;


import item.mobileItem.ingredient.FriedEgg;
import item.mobileItem.ingredient.Ingredient;
import model.SpriteShape;

public class FriedEggRecipe extends ConcreteRecipe {

    public FriedEggRecipe(SpriteShape productShape) {
        super(productShape, "rawegg");
    }

    protected Ingredient getResult() {
        return new FriedEgg(null, productShape);
    }
}
