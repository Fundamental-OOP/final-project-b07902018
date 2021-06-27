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

import crafting.Crafter;
import crafting.receipes.TwoToOne;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class Tabel extends StaticItem implements PlaceItemOn, PlaceItemIn{

    protected final SpriteShape shape;
    public Crafter cft;


    public Tabel(Point location) {
        super(location);
        cft = new Crafter();
        cft.rcps.add(new TwoToOne());
        
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        State idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/table/idle", imageRenderer)));

        fsm.setInitialState(idle);
    }

    @Override
    public Point itemPlaceLocation() {
        return this.getLocation();
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

    @Override
    public void putin(Item itm) {
        cft.putItem(itm);
        
    }
    
}
