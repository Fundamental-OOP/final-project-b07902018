package item.staticItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Item;
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

    State idle;

    public StaticItem(Point location) {
        super(location);
    }


    public void update() {
        //fsm.update();
    }

    @Override
    public void render(Graphics g) {
        //super.render(g);
        idle.render(g);
    }

    @Override
    public Point getLocation() {
        return location;
    }


}
