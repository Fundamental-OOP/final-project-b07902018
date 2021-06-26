package item;

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

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Item extends Sprite {
    protected final SpriteShape shape;
    protected final FiniteStateMachine fsm;


    public Item(Point location) {
        this.location = location;
        shape = new SpriteShape(new Dimension(146, 176),
                new Dimension(33, 38), new Dimension(66, 105));
        fsm = new FiniteStateMachine();

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/idle", imageRenderer)));

        fsm.setInitialState(idle);
    }


    @Override
    public void update() {
        fsm.update();
    }

    @Override
    public void render(Graphics g) {
        //super.render(g);
        fsm.render(g);
    }


    @Override
    public Point getLocation() {
        return location;
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
