package item.staticItem;

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
import model.SpriteShape;

public class VegetableFactory extends StaticItem implements Factory {

    protected final SpriteShape shape;
    protected final Point thisLocation;

    public VegetableFactory(Point location) {
        super(location);

        shape = new SpriteShape(new Dimension(146, 176), new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4, new Idle(imageStatesFromFolder("assets/item/knightFactory/idle", imageRenderer)));
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

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    }

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    }

}
