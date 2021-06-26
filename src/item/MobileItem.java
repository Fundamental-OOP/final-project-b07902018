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
public class MobileItem extends Item {
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum Event {
        MOVE, STOP, ATTACK, DAMAGED
    }

    public MobileItem(Point location) {
        super(location);

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/mobileItem/idle", imageRenderer)));
        State moving = new WaitingPerFrame(2,
                new Moving(this, imageStatesFromFolder("assets/mobileItem/walking", imageRenderer)));

        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(MOVE).to(moving));
        fsm.addTransition(from(moving).when(STOP).to(idle));
    }

    public void move(Direction direction) {
        if (direction == LEFT || direction == Direction.RIGHT) {
            face = direction;
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
            fsm.trigger(MOVE);
        }
    }

    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            fsm.trigger(STOP);
        }
    }

    public void update() {
        fsm.update();
    }

    @Override
    public void render(Graphics g) {
        //super.render(g);
        fsm.render(g);
    }

    public Set<Direction> getDirections() {
        return directions;
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
