package item.ingredient;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import item.*;
import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class Ingredient extends MobileItem {

    protected final SpriteShape shape;
    protected final String ingredientName;

    public Ingredient(Point location, String name) {
        super(location);
        shape = new SpriteShape(new Dimension(50, 50), new Dimension(33, 38), new Dimension(66, 105));
        ingredientName = name;
        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4, new Idle(imageStatesFromFolder("assets/item/" + ingredientName, imageRenderer)));
        State moving = new WaitingPerFrame(2,
                new Moving(this, imageStatesFromFolder("assets/item/" + ingredientName, imageRenderer)));
        State freeze = new WaitingPerFrame(0,
                new Freeze(this, fsm, imageStatesFromFolder("assets/item/" + ingredientName, imageRenderer)));

        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(MOVE).to(moving));
        fsm.addTransition(from(moving).when(STOP).to(idle));
        fsm.addTransition(from(idle).when(FREEZE).to(freeze));
        fsm.addTransition(from(moving).when(FREEZE).to(freeze));
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
