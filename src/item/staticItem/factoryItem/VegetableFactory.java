package item.staticItem.factoryItem;

import static utils.ImageStateUtils.imageStatesFromFolder;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import fsm.ImageRenderer;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.mobileItem.ingredient.Ingredient;
import item.mobileItem.ingredient.Lechuga;
import item.mobileItem.ingredient.Maiz;
import item.mobileItem.ingredient.Onion;
import item.mobileItem.ingredient.Pepino;
import item.mobileItem.ingredient.Tomato;
import item.staticItem.StaticItem;
import model.SpriteShape;

public class VegetableFactory extends FactoryItem {

    protected final Point thisLocation;

    public VegetableFactory(Point location) {
        super(location, "box");
        thisLocation = location;
    }

    @Override
    public MobileItem produceItem() {
        int random = (int) (Math.random() * 5);
        Ingredient ingredient;
        switch (random) {
            case 0:
                ingredient = new Onion(thisLocation);
                break;
            case 1:
                ingredient = new Maiz(thisLocation);
                break;
            case 2:
                ingredient = new Lechuga(thisLocation);
                break;
            case 3:
                ingredient = new Pepino(thisLocation);
                break;
            case 4:
                ingredient = new Tomato(thisLocation);
                break;
            default:
                ingredient = null;
        }
        this.world.addSprite(ingredient);
        return ingredient;
    }

}
