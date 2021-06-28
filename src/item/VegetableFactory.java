package item;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.ingredient.*;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

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
