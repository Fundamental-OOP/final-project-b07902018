package item.staticItem.craftingItem;

import java.awt.Point;

import crafting.recipe.ApplepieRecipe;
import crafting.recipe.FriedEggRecipe;
import crafting.recipe.FruitSaladRecipe;
import crafting.recipe.SaladRecipe;
import item.mobileItem.MobileItem;
import model.SpriteShape;

public class SaladBowl extends Crafter {

    public SaladBowl(Point location, SpriteShape shape, SpriteShape productShape) {
        super(location, shape, productShape, "saladbowl");
        //recipes.add(new ApplepieRecipe());
        recipes.add(new SaladRecipe(productShape));
        recipes.add(new FruitSaladRecipe(productShape));

        maxItemNumber = 3;
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        int x = this.getX();
        int y = this.getY();
        int w = this.getRange().width;
        int h = this.getRange().height;
        int index = items.indexOf(item);

        int itemWidth = item.getRange().width;
        int itemHeight = item.getRange().height;

        int wOffset = (w - itemWidth * 2) / 2;
        int hOffset =  h * 3 / 10;
        if(index == 0){
            index = 1;
        }
        else if (index == 1){
            index = 0;
        }
        //return new Point(x - itemWidth / 2 + index * (itemWidth + wOffset), y + hOffset); 

        return new Point(x - itemWidth / 2 + index * (itemWidth + wOffset), y); 
    }
    
}
