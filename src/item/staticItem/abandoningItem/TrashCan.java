package item.staticItem.abandoningItem;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import item.Idle;
import item.ItemImageRenderer;
import item.mobileItem.MobileItem;
import item.staticItem.PlaceItemOn;
import item.staticItem.StaticItem;
import model.Direction;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class TrashCan extends StaticItem implements PlaceItemOn {

    private ArrayList<MobileItem> items;

    protected final SpriteShape shape;


    public TrashCan(Point location) {
        super(location);
        items = new ArrayList<>();
        
        shape = new SpriteShape(new Dimension(100, 100),
        new Dimension(10, 10), new Dimension(80, 80));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/trashcan", imageRenderer)));
    }

    @Override
    public Point itemPlaceLocation(MobileItem item) {
        return this.getLocation();
    }


    @Override
    public void tryAcquireItem(MobileItem item) {
        items.add(item);
        item.setLocation(itemPlaceLocation(item));
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

    public void clearTrashCan(){
        for(MobileItem item : items){
            item.getWorld().removeSprite(item);
            //item.setWorld(null);
        }
        items.clear();
    }

    @Override
    public void update(){
        clearTrashCan();
    }

    @Override
    public boolean hasSpace() {
        return true;
    }

    @Override
    public boolean canPickUpItem() {
        return false;
    }

    @Override
    public MobileItem popItem() {
        return null;
    }

    @Override
    public boolean hasItem() {
        return false;
    }

}
