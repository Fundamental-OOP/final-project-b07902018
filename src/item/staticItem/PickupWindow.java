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
import order.OrderList;
import scoring.Scoreboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import crafting.Crafter;
import crafting.ScoreComputer;
import crafting.recipe.TwoToOne;

import static fsm.FiniteStateMachine.Transition.from;
import static fsm.Event.*;
import static model.Direction.LEFT;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class PickupWindow extends StaticItem implements PlaceItemOn {

    private OrderList pendingOrders;

    private Scoreboard scoreboard;

    private ScoreComputer scoreComputer;

    private ArrayList<MobileItem> items;

    protected final SpriteShape shape;

    public PickupWindow(Point location, OrderList pendingOrders, Scoreboard scoreboard, ScoreComputer scoreComputer) {
        super(location);
        items = new ArrayList<>();
        this.pendingOrders = pendingOrders;
        this.scoreboard = scoreboard;
        this.scoreComputer = scoreComputer;
        
        shape = new SpriteShape(new Dimension(146, 176),
        new Dimension(40, 38), new Dimension(66, 105));

        ImageRenderer imageRenderer = new ItemImageRenderer(this);
        idle = new WaitingPerFrame(4,
                new Idle(imageStatesFromFolder("assets/item/pickupwindow", imageRenderer)));
    }

    @Override
    public Point itemPlaceLocation() {
        return this.getLocation();
    }


    @Override
    public void tryAcquireItem(MobileItem item) {
        items.add(item);
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

    public void clearItems(){
        for(MobileItem item : items){
            item.getWorld().removeSprite(item);
            //item.setWorld(null);
        }
        items.clear();
    }

    @Override
    public void update(){
        for(MobileItem item : items){
            if(pendingOrders.contain(item)){
                pendingOrders.completeOrder(item);
                scoreboard.increaseScore(scoreComputer.computeScore(item));
            }
        }
        clearItems();
    }

    @Override
    public boolean hasSpace() {
        return true;
    }

    @Override
    public boolean hasItem() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canPickUpItem() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public MobileItem popItem() {
        // TODO Auto-generated method stub
        return null;
    }

}
