package item.staticItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import crafting.Crafter;
import crafting.recipe.TwoToOne;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class Table extends StaticItem implements PlaceItemOn {

    private ArrayList<MobileItem> itemOntable;

    protected final SpriteShape shape;


    public Table(Point location) {
        super(location);
        itemOntable = new ArrayList<>();
        
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/table", imageRenderer)));
    }

    @Override
    public Point itemPlaceLocation() {
        return this.getLocation();
    }


    @Override
    public void tryAcquireItem(MobileItem item) {
        itemOntable.add(item);
        item.setLocation(itemPlaceLocation());
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
    public boolean hasSpace() {
        // TODO Auto-generated method stub
        return true;
    }

}
