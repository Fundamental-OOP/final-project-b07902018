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
    protected final List<Ingredient> possibleIngredient;

    public VegetableFactory(Point location) {
        super(location);

        shape = new SpriteShape(new Dimension(146, 176), new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4, new Idle(imageStatesFromFolder("assets/item/knightFactory/idle", imageRenderer)));
        possibleIngredient = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            possibleIngredient.add(new Onion(location));
            possibleIngredient.add(new Maiz(location));
            possibleIngredient.add(new Lechuga(location));
            possibleIngredient.add(new Pepino(location));
            possibleIngredient.add(new Tomato(location));
        }
    }

    @Override
    public MobileItem produceItem() {
        int random = (int) (Math.random() * possibleIngredient.size());
        Ingredient ingredient = possibleIngredient.get(random);
        possibleIngredient.remove(ingredient);
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
