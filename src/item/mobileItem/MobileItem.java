package item.mobileItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Item;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import character.Character;

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
public abstract class MobileItem extends Item {
 
    protected final FiniteStateMachine fsm;

    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    private Character owner;


    public MobileItem(Point location) {
        super(location);
        fsm = new FiniteStateMachine();
        owner = null;
    }

    public void move(Direction direction) {
        if (direction == LEFT || direction == Direction.RIGHT) {
            face = direction;
        }
        if(owner.mobileItemLocation() != getLocation()){
            this.setLocation(owner.mobileItemLocation());
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

    public void setOwner(Character character){
        owner = character;
        //fsm.trigger(ISPICKED);
    }

    public void beReleased(){
        owner = null;
        //fsm.trigger(ISRELEASED);
    }

    public void freeze() {
        fsm.trigger(FREEZE);
    }

    public void update() {
        fsm.update();
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public boolean hasOwner(){
        return owner != null;
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