package character;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.MobileItem;
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
public class Character extends Sprite {
    private final SpriteShape shape;
    private final FiniteStateMachine fsm;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    private MobileItem mobileItem;

    public Character(Point location) {
        this.location = location;
        shape = new SpriteShape(new Dimension(146, 176),
                new Dimension(40, 38), new Dimension(66, 105));
        fsm = new FiniteStateMachine();
        this.mobileItem = null;

        ImageRenderer imageRenderer = new CharacterImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/character/idle", imageRenderer)));
        State walking = new WaitingPerFrame(2,
                new Walking(this, imageStatesFromFolder("assets/character/walking", imageRenderer)));
        State picking = new WaitingPerFrame(0,
                new Picking(this, fsm, imageStatesFromFolder("assets/character/picking", imageRenderer)));
        State releasing = new WaitingPerFrame(2,
                new Releasing(this, fsm, imageStatesFromFolder("assets/character/releasing", imageRenderer)));
        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(WALK).to(walking));
        fsm.addTransition(from(walking).when(STOP).to(idle));
        fsm.addTransition(from(idle).when(PICK).to(picking));
        fsm.addTransition(from(walking).when(PICK).to(picking));
        fsm.addTransition(from(idle).when(RELEASE).to(releasing));
        fsm.addTransition(from(walking).when(RELEASE).to(releasing));

        //fsm.addTransition(from(picking).when(WALK).to(walking));
    }

    public void move(Direction direction) {
        if (direction == LEFT || direction == Direction.RIGHT) {
            face = direction;
            if(hasMobileItem() && mobileItem.getFace() != face){
                mobileItem.setLocation(mobileItemLocation());
            }
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
            fsm.trigger(WALK);
        }
    }

    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            fsm.trigger(STOP);
        }
    }


    public void pickUp(){
        fsm.trigger(PICK);
    }

    public void tryRelease(){
        fsm.trigger(RELEASE);
    }

    public void update() {
        fsm.update();
    }
/*
    public boolean isPerforming(){
        State currentState = fsm.currentState();
        return (currentState instanceof Picking) || (currentState instanceof Releasing);
    }
*/
    public void addMobileItem(MobileItem mobileItem){
        if(mobileItem instanceof MobileItem){
            this.mobileItem = mobileItem;
        }
    }

    public boolean hasMobileItem(){
        return mobileItem != null;
    }

    public MobileItem getMobileItem(){
        return mobileItem;
    }

    public void releaseMobileItem(Point location){
        mobileItem.setLocation(location);
        mobileItem = null;
    }

    public Point mobileItemLocation(){
        if(this.getFace() == Direction.RIGHT){
            return new Point(this.getX() + this.getRange().width / 3, this.getY());
        }
        else{
            return new Point(this.getX() - this.getRange().width / 3, this.getY());
        }
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
    public void setLocation(Point location) {
        this.location = location;
        if(hasMobileItem()){
            mobileItem.setLocation(mobileItemLocation());
        }
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
