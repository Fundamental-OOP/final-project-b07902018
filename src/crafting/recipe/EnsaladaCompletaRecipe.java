package crafting.recipe;

import java.awt.Point;

import item.mobileItem.ingredient.EnsaladaCompleta;
import item.mobileItem.ingredient.Ingredient;

public class EnsaladaCompletaRecipe extends ConcreteRecipe {

    public EnsaladaCompletaRecipe() {
        super("lechuga", "tomato", "pepino");
    }

    protected Ingredient getResult() {
        return new EnsaladaCompleta(new Point(0, 0));
    }
}
