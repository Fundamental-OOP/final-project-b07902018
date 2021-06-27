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

public abstract class StaticItem extends Item {


    protected final FiniteStateMachine fsm;

    private final Set<Direction> directions = new CopyOnWriteArraySet<>();


    public StaticItem(Point location) {
        super(location);
        fsm = new FiniteStateMachine();
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

    public void picked(){
        fsm.trigger(ISPICKED);
    }

    public void released(){
        fsm.trigger(ISRELEASED);
    }

    public void update() {
        fsm.update();
    }

    public Set<Direction> getDirections() {
        return directions;
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


    
}
