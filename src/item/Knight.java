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

public class Knight extends MobileItem {

    protected final SpriteShape shape;

    public Knight(Point location) {
        super(location);
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(33, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/knight/idle", imageRenderer)));
        State moving = new WaitingPerFrame(2,
                new Moving(this, imageStatesFromFolder("assets/item/knight/walking", imageRenderer)));
        State gettingPicked = new WaitingPerFrame(0,
               new GettingPicked(this, fsm, imageStatesFromFolder("assets/item/knight/gettingPicked", imageRenderer)));
        State gettingReleased = new WaitingPerFrame(0,
               new GettingReleased(this, fsm, imageStatesFromFolder("assets/item/knight/gettingReleased", imageRenderer)));

        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(MOVE).to(moving));
        fsm.addTransition(from(moving).when(STOP).to(idle));
        fsm.addTransition(from(idle).when(ISPICKED).to(gettingPicked));
        fsm.addTransition(from(moving).when(ISPICKED).to(gettingPicked));
        fsm.addTransition(from(idle).when(ISRELEASED).to(gettingReleased));
        fsm.addTransition(from(moving).when(ISRELEASED).to(gettingReleased));
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
