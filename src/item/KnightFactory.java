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

public class KnightFactory extends StaticItem implements Factory {

    protected final SpriteShape shape;

    public KnightFactory(Point location) {
        super(location);

        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/knightFactory/idle", imageRenderer)));

        fsm.setInitialState(idle);
    }

    @Override
    public MobileItem produceItem() {
        Knight newKnight =  new Knight(new Point(150, 150));
        this.world.addSprite(newKnight);
        return newKnight;
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
