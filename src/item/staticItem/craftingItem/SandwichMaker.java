package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;
import crafting.recipe.CheeseEggSandwichRecipe;
import crafting.recipe.FriedEggRecipe;
import crafting.recipe.VegetableSandwichRecipe;
import item.mobileItem.MobileItem;
import model.SpriteShape;

public class SandwichMaker extends Crafter {

    public SandwichMaker(Point location, SpriteShape shape, SpriteShape productShape) {
        super(location, shape, productShape, "sandwichmaker");
        recipes.add(new VegetableSandwichRecipe(productShape));
        recipes.add(new CheeseEggSandwichRecipe(productShape));

        maxItemNumber = 3;
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        int x = this.getX();
        int y = this.getY();
        int w = this.getRange().width;
        int h = this.getRange().height;
        int index = items.indexOf(item);
        if(index == 0){
            index = 1;
        }
        else if (index == 1){
            index = 0;
        }
        return new Point(x - 15 + index * 40, y + (h * 3 / 10)); 
    }

    
}
